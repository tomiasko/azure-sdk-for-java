package com.azure.digitaltwins.core;

import com.azure.core.http.HttpClient;
import com.azure.digitaltwins.core.models.ModelData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import reactor.test.StepVerifier;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.azure.digitaltwins.core.TestHelper.DISPLAY_NAME_WITH_ARGUMENTS;
import static com.azure.digitaltwins.core.TestHelper.assertRestException;
import static org.junit.jupiter.api.Assertions.*;

public class ModelsAsyncTest extends ModelsTestBase {
    private DigitalTwinsAsyncClient asyncClient;

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.digitaltwins.core.TestHelper#getTestParameters")
    @Override
    public void modelLifecycleTest(HttpClient httpClient, DigitalTwinsServiceVersion serviceVersion) {
        asyncClient = getAsyncClient(httpClient, serviceVersion);

        // Create some models to test the lifecycle of
        List<ModelData> createdModels = new ArrayList<>();
        createModelsRunner(asyncClient, (modelsList) -> {
            StepVerifier.create(asyncClient.createModels(modelsList))
                .assertNext(createdModel -> {
                    // When creating models, the service will not return the model itself, so it will be manually
                    // assigned here and below to make comparisons easier
                    createdModel.setModel(modelsList.get(0));
                    createdModels.add(createdModel);
                })
                .assertNext(createdModel -> {
                    createdModel.setModel(modelsList.get(1));
                    createdModels.add(createdModel);
                })
                .assertNext(createdModel -> {
                    createdModel.setModel(modelsList.get(2));
                    createdModels.add(createdModel);
                })
                .verifyComplete();
        });

        for (int modelIndex = 0; modelIndex < createdModels.size(); modelIndex++) {
            // indices used in lambda expressions must be declared final, hence this duplicate
            int finalModelIndex = modelIndex;
            final ModelData expected = createdModels.get(modelIndex);

            // Get the model
            getModelRunner(expected.getId(), (modelId) -> {
                StepVerifier.create(asyncClient.getModelWithResponse(modelId))
                    .assertNext(retrievedModel -> {
                        assertModelDataAreEqual(createdModels.get(finalModelIndex), retrievedModel.getValue());
                    })
                    .verifyComplete();
            });

            // Decommission the model
            decommissionModelRunner(expected.getId(), (modelId) -> {
                StepVerifier.create(asyncClient.decommissionModel(modelId))
                    .verifyComplete();
            });

            // Get the model again to see if it was decommissioned as expected
            getModelRunner(expected.getId(), (modelId) -> {
                StepVerifier.create(asyncClient.getModel(modelId))
                    .assertNext(retrievedModel -> {
                        assertTrue(retrievedModel.isDecommissioned());
                    })
                    .verifyComplete();
            });

            // Delete the model
            deleteModelRunner(expected.getId(), (modelId) -> {
                StepVerifier.create(asyncClient.deleteModel(modelId))
                    .verifyComplete();
            });
        }
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.digitaltwins.core.TestHelper#getTestParameters")
    @Override
    public void getModelThrowsIfModelDoesNotExist(HttpClient httpClient, DigitalTwinsServiceVersion serviceVersion) {
        DigitalTwinsAsyncClient asyncClient = getAsyncClient(httpClient, serviceVersion);
        final String nonExistantModelId = "urn:doesnotexist:fakemodel:1000";
        StepVerifier.create(asyncClient.getModel(nonExistantModelId))
            .verifyErrorSatisfies(ex -> assertRestException(ex, HttpURLConnection.HTTP_NOT_FOUND));
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.digitaltwins.core.TestHelper#getTestParameters")
    @Override
    public void createModelThrowsIfModelAlreadyExists(HttpClient httpClient, DigitalTwinsServiceVersion serviceVersion) {
        DigitalTwinsAsyncClient asyncClient = getAsyncClient(httpClient, serviceVersion);

        final List<String> modelsToCreate = new ArrayList<>();
        final String wardModelId = TestAssetsHelper.GetUniqueModelId(asyncClient, TestAssetDefaults.WardModelId);
        final String wardModelPayload = TestAssetsHelper.GetWardModelPayload(wardModelId);
        modelsToCreate.add(wardModelPayload);

        StepVerifier.create(asyncClient.createModels(modelsToCreate))
            .assertNext((modelData -> {
                assertNotNull(modelData);
            }))
            .verifyComplete();

        StepVerifier.create(asyncClient.createModels(modelsToCreate))
            .verifyErrorSatisfies(ex -> assertRestException(ex, HttpURLConnection.HTTP_CONFLICT));
    }

    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.digitaltwins.core.TestHelper#getTestParameters")
    @Override
    public void getModelThrowsIfModelIdInvalid(HttpClient httpClient, DigitalTwinsServiceVersion serviceVersion) {
        DigitalTwinsAsyncClient asyncClient = getAsyncClient(httpClient, serviceVersion);
        final String malformedModelId = "thisIsNotAValidModelId";
        StepVerifier.create(asyncClient.getModel(malformedModelId))
            .verifyErrorSatisfies(ex -> assertRestException(ex, HttpURLConnection.HTTP_BAD_REQUEST));
    }

    private static void createModelsRunner(DigitalTwinsAsyncClient asyncClient, Consumer<List<String>> createModelsTestRunner) {
        String buildingModelId = TestAssetsHelper.GetUniqueModelId(asyncClient, TestAssetDefaults.BuildingModelId);
        String floorModelId = TestAssetsHelper.GetUniqueModelId(asyncClient, TestAssetDefaults.FloorModelId);
        String hvacModelId = TestAssetsHelper.GetUniqueModelId(asyncClient, TestAssetDefaults.HvacModelId);
        String wardModelId = TestAssetsHelper.GetUniqueModelId(asyncClient, TestAssetDefaults.WardModelId);

        createModelsRunner(buildingModelId, floorModelId, hvacModelId, wardModelId, createModelsTestRunner);
    }

    private DigitalTwinsAsyncClient getAsyncClient(HttpClient httpClient, DigitalTwinsServiceVersion serviceVersion)
    {
        return getDigitalTwinsClientBuilder().serviceVersion(serviceVersion).httpClient(httpClient).buildAsyncClient();
    }
}

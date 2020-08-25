/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.subscription.v2020_09_01.implementation;

import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.AzureResponseBuilder;
import com.microsoft.azure.credentials.AzureTokenCredentials;
import com.microsoft.azure.management.apigeneration.Beta;
import com.microsoft.azure.management.apigeneration.Beta.SinceVersion;
import com.microsoft.azure.arm.resources.AzureConfigurable;
import com.microsoft.azure.serializer.AzureJacksonAdapter;
import com.microsoft.rest.RestClient;
import com.microsoft.azure.management.subscription.v2020_09_01.Subscriptions;
import com.microsoft.azure.management.subscription.v2020_09_01.Tenants;
import com.microsoft.azure.management.subscription.v2020_09_01.SubscriptionServices;
import com.microsoft.azure.management.subscription.v2020_09_01.Operations;
import com.microsoft.azure.management.subscription.v2020_09_01.Alias;
import com.microsoft.azure.arm.resources.implementation.AzureConfigurableCoreImpl;
import com.microsoft.azure.arm.resources.implementation.ManagerCore;

/**
 * Entry point to Azure  resource management.
 */
public final class SubscriptionManager extends ManagerCore<SubscriptionManager, SubscriptionClientImpl> {
    private Subscriptions subscriptions;
    private Tenants tenants;
    private SubscriptionServices subscriptionServices;
    private Operations operations;
    private Alias alias;
    /**
    * Get a Configurable instance that can be used to create SubscriptionManager with optional configuration.
    *
    * @return the instance allowing configurations
    */
    public static Configurable configure() {
        return new SubscriptionManager.ConfigurableImpl();
    }
    /**
    * Creates an instance of SubscriptionManager that exposes  resource management API entry points.
    *
    * @param credentials the credentials to use
    * @return the SubscriptionManager
    */
    public static SubscriptionManager authenticate(AzureTokenCredentials credentials) {
        return new SubscriptionManager(new RestClient.Builder()
            .withBaseUrl(credentials.environment(), AzureEnvironment.Endpoint.RESOURCE_MANAGER)
            .withCredentials(credentials)
            .withSerializerAdapter(new AzureJacksonAdapter())
            .withResponseBuilderFactory(new AzureResponseBuilder.Factory())
            .build());
    }
    /**
    * Creates an instance of SubscriptionManager that exposes  resource management API entry points.
    *
    * @param restClient the RestClient to be used for API calls.
    * @return the SubscriptionManager
    */
    public static SubscriptionManager authenticate(RestClient restClient) {
        return new SubscriptionManager(restClient);
    }
    /**
    * The interface allowing configurations to be set.
    */
    public interface Configurable extends AzureConfigurable<Configurable> {
        /**
        * Creates an instance of SubscriptionManager that exposes  management API entry points.
        *
        * @param credentials the credentials to use
        * @return the interface exposing  management API entry points that work across subscriptions
        */
        SubscriptionManager authenticate(AzureTokenCredentials credentials);
    }

    /**
     * @return Entry point to manage Subscriptions.
     */
    public Subscriptions subscriptions() {
        if (this.subscriptions == null) {
            this.subscriptions = new SubscriptionsImpl(this);
        }
        return this.subscriptions;
    }

    /**
     * @return Entry point to manage Tenants.
     */
    public Tenants tenants() {
        if (this.tenants == null) {
            this.tenants = new TenantsImpl(this);
        }
        return this.tenants;
    }

    /**
     * @return Entry point to manage SubscriptionServices.
     */
    public SubscriptionServices subscriptionServices() {
        if (this.subscriptionServices == null) {
            this.subscriptionServices = new SubscriptionServicesImpl(this);
        }
        return this.subscriptionServices;
    }

    /**
     * @return Entry point to manage Operations.
     */
    public Operations operations() {
        if (this.operations == null) {
            this.operations = new OperationsImpl(this);
        }
        return this.operations;
    }

    /**
     * @return Entry point to manage Alias.
     */
    public Alias alias() {
        if (this.alias == null) {
            this.alias = new AliasImpl(this);
        }
        return this.alias;
    }

    /**
    * The implementation for Configurable interface.
    */
    private static final class ConfigurableImpl extends AzureConfigurableCoreImpl<Configurable> implements Configurable {
        public SubscriptionManager authenticate(AzureTokenCredentials credentials) {
           return SubscriptionManager.authenticate(buildRestClient(credentials));
        }
     }
    private SubscriptionManager(RestClient restClient) {
        super(
            restClient,
            null,
            new SubscriptionClientImpl(restClient));
    }
}

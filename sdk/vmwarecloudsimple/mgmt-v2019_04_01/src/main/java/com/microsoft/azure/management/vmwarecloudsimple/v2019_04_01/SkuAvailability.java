/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.vmwarecloudsimple.v2019_04_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.vmwarecloudsimple.v2019_04_01.implementation.SkuAvailabilityInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.vmwarecloudsimple.v2019_04_01.implementation.VMwareCloudSimpleManager;

/**
 * Type representing SkuAvailability.
 */
public interface SkuAvailability extends HasInner<SkuAvailabilityInner>, HasManager<VMwareCloudSimpleManager> {
    /**
     * @return the dedicatedAvailabilityZoneId value.
     */
    String dedicatedAvailabilityZoneId();

    /**
     * @return the dedicatedAvailabilityZoneName value.
     */
    String dedicatedAvailabilityZoneName();

    /**
     * @return the dedicatedPlacementGroupId value.
     */
    String dedicatedPlacementGroupId();

    /**
     * @return the dedicatedPlacementGroupName value.
     */
    String dedicatedPlacementGroupName();

    /**
     * @return the limit value.
     */
    int limit();

    /**
     * @return the resourceType value.
     */
    String resourceType();

    /**
     * @return the skuId value.
     */
    String skuId();

    /**
     * @return the skuName value.
     */
    String skuName();

}
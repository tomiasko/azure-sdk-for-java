/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.v2018_02_01.implementation;

import com.microsoft.azure.management.appservice.v2018_02_01.SkuDescription;
import com.microsoft.azure.management.appservice.v2018_02_01.SkuCapacity;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * SKU discovery information.
 */
public class SkuInfoInner {
    /**
     * Resource type that this SKU applies to.
     */
    @JsonProperty(value = "resourceType")
    private String resourceType;

    /**
     * Name and tier of the SKU.
     */
    @JsonProperty(value = "sku")
    private SkuDescription sku;

    /**
     * Min, max, and default scale values of the SKU.
     */
    @JsonProperty(value = "capacity")
    private SkuCapacity capacity;

    /**
     * Get resource type that this SKU applies to.
     *
     * @return the resourceType value
     */
    public String resourceType() {
        return this.resourceType;
    }

    /**
     * Set resource type that this SKU applies to.
     *
     * @param resourceType the resourceType value to set
     * @return the SkuInfoInner object itself.
     */
    public SkuInfoInner withResourceType(String resourceType) {
        this.resourceType = resourceType;
        return this;
    }

    /**
     * Get name and tier of the SKU.
     *
     * @return the sku value
     */
    public SkuDescription sku() {
        return this.sku;
    }

    /**
     * Set name and tier of the SKU.
     *
     * @param sku the sku value to set
     * @return the SkuInfoInner object itself.
     */
    public SkuInfoInner withSku(SkuDescription sku) {
        this.sku = sku;
        return this;
    }

    /**
     * Get min, max, and default scale values of the SKU.
     *
     * @return the capacity value
     */
    public SkuCapacity capacity() {
        return this.capacity;
    }

    /**
     * Set min, max, and default scale values of the SKU.
     *
     * @param capacity the capacity value to set
     * @return the SkuInfoInner object itself.
     */
    public SkuInfoInner withCapacity(SkuCapacity capacity) {
        this.capacity = capacity;
        return this;
    }

}
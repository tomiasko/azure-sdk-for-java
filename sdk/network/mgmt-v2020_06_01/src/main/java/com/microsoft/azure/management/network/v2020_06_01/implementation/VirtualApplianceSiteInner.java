/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_06_01.implementation;

import com.microsoft.azure.management.network.v2020_06_01.Office365PolicyProperties;
import com.microsoft.azure.management.network.v2020_06_01.ProvisioningState;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.SubResource;

/**
 * Virtual Appliance Site resource.
 */
@JsonFlatten
public class VirtualApplianceSiteInner extends SubResource {
    /**
     * Address Prefix.
     */
    @JsonProperty(value = "properties.addressPrefix")
    private String addressPrefix;

    /**
     * Office 365 Policy.
     */
    @JsonProperty(value = "properties.o365Policy")
    private Office365PolicyProperties o365Policy;

    /**
     * The provisioning state of the resource. Possible values include:
     * 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * Name of the virtual appliance site.
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * A unique read-only string that changes whenever the resource is updated.
     */
    @JsonProperty(value = "etag", access = JsonProperty.Access.WRITE_ONLY)
    private String etag;

    /**
     * Site type.
     */
    @JsonProperty(value = "type", access = JsonProperty.Access.WRITE_ONLY)
    private String type;

    /**
     * Get address Prefix.
     *
     * @return the addressPrefix value
     */
    public String addressPrefix() {
        return this.addressPrefix;
    }

    /**
     * Set address Prefix.
     *
     * @param addressPrefix the addressPrefix value to set
     * @return the VirtualApplianceSiteInner object itself.
     */
    public VirtualApplianceSiteInner withAddressPrefix(String addressPrefix) {
        this.addressPrefix = addressPrefix;
        return this;
    }

    /**
     * Get office 365 Policy.
     *
     * @return the o365Policy value
     */
    public Office365PolicyProperties o365Policy() {
        return this.o365Policy;
    }

    /**
     * Set office 365 Policy.
     *
     * @param o365Policy the o365Policy value to set
     * @return the VirtualApplianceSiteInner object itself.
     */
    public VirtualApplianceSiteInner withO365Policy(Office365PolicyProperties o365Policy) {
        this.o365Policy = o365Policy;
        return this;
    }

    /**
     * Get the provisioning state of the resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get name of the virtual appliance site.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set name of the virtual appliance site.
     *
     * @param name the name value to set
     * @return the VirtualApplianceSiteInner object itself.
     */
    public VirtualApplianceSiteInner withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get a unique read-only string that changes whenever the resource is updated.
     *
     * @return the etag value
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get site type.
     *
     * @return the type value
     */
    public String type() {
        return this.type;
    }

}

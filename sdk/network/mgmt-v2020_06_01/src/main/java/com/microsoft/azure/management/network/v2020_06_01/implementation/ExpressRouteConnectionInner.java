/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_06_01.implementation;

import com.microsoft.azure.management.network.v2020_06_01.ProvisioningState;
import com.microsoft.azure.management.network.v2020_06_01.ExpressRouteCircuitPeeringId;
import com.microsoft.azure.management.network.v2020_06_01.RoutingConfiguration;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.azure.SubResource;

/**
 * ExpressRouteConnection resource.
 */
@JsonFlatten
public class ExpressRouteConnectionInner extends SubResource {
    /**
     * The provisioning state of the express route connection resource.
     * Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     */
    @JsonProperty(value = "properties.provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /**
     * The ExpressRoute circuit peering.
     */
    @JsonProperty(value = "properties.expressRouteCircuitPeering", required = true)
    private ExpressRouteCircuitPeeringId expressRouteCircuitPeering;

    /**
     * Authorization key to establish the connection.
     */
    @JsonProperty(value = "properties.authorizationKey")
    private String authorizationKey;

    /**
     * The routing weight associated to the connection.
     */
    @JsonProperty(value = "properties.routingWeight")
    private Integer routingWeight;

    /**
     * Enable internet security.
     */
    @JsonProperty(value = "properties.enableInternetSecurity")
    private Boolean enableInternetSecurity;

    /**
     * The Routing Configuration indicating the associated and propagated route
     * tables on this connection.
     */
    @JsonProperty(value = "properties.routingConfiguration")
    private RoutingConfiguration routingConfiguration;

    /**
     * The name of the resource.
     */
    @JsonProperty(value = "name", required = true)
    private String name;

    /**
     * Get the provisioning state of the express route connection resource. Possible values include: 'Succeeded', 'Updating', 'Deleting', 'Failed'.
     *
     * @return the provisioningState value
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the ExpressRoute circuit peering.
     *
     * @return the expressRouteCircuitPeering value
     */
    public ExpressRouteCircuitPeeringId expressRouteCircuitPeering() {
        return this.expressRouteCircuitPeering;
    }

    /**
     * Set the ExpressRoute circuit peering.
     *
     * @param expressRouteCircuitPeering the expressRouteCircuitPeering value to set
     * @return the ExpressRouteConnectionInner object itself.
     */
    public ExpressRouteConnectionInner withExpressRouteCircuitPeering(ExpressRouteCircuitPeeringId expressRouteCircuitPeering) {
        this.expressRouteCircuitPeering = expressRouteCircuitPeering;
        return this;
    }

    /**
     * Get authorization key to establish the connection.
     *
     * @return the authorizationKey value
     */
    public String authorizationKey() {
        return this.authorizationKey;
    }

    /**
     * Set authorization key to establish the connection.
     *
     * @param authorizationKey the authorizationKey value to set
     * @return the ExpressRouteConnectionInner object itself.
     */
    public ExpressRouteConnectionInner withAuthorizationKey(String authorizationKey) {
        this.authorizationKey = authorizationKey;
        return this;
    }

    /**
     * Get the routing weight associated to the connection.
     *
     * @return the routingWeight value
     */
    public Integer routingWeight() {
        return this.routingWeight;
    }

    /**
     * Set the routing weight associated to the connection.
     *
     * @param routingWeight the routingWeight value to set
     * @return the ExpressRouteConnectionInner object itself.
     */
    public ExpressRouteConnectionInner withRoutingWeight(Integer routingWeight) {
        this.routingWeight = routingWeight;
        return this;
    }

    /**
     * Get enable internet security.
     *
     * @return the enableInternetSecurity value
     */
    public Boolean enableInternetSecurity() {
        return this.enableInternetSecurity;
    }

    /**
     * Set enable internet security.
     *
     * @param enableInternetSecurity the enableInternetSecurity value to set
     * @return the ExpressRouteConnectionInner object itself.
     */
    public ExpressRouteConnectionInner withEnableInternetSecurity(Boolean enableInternetSecurity) {
        this.enableInternetSecurity = enableInternetSecurity;
        return this;
    }

    /**
     * Get the Routing Configuration indicating the associated and propagated route tables on this connection.
     *
     * @return the routingConfiguration value
     */
    public RoutingConfiguration routingConfiguration() {
        return this.routingConfiguration;
    }

    /**
     * Set the Routing Configuration indicating the associated and propagated route tables on this connection.
     *
     * @param routingConfiguration the routingConfiguration value to set
     * @return the ExpressRouteConnectionInner object itself.
     */
    public ExpressRouteConnectionInner withRoutingConfiguration(RoutingConfiguration routingConfiguration) {
        this.routingConfiguration = routingConfiguration;
        return this;
    }

    /**
     * Get the name of the resource.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the resource.
     *
     * @param name the name value to set
     * @return the ExpressRouteConnectionInner object itself.
     */
    public ExpressRouteConnectionInner withName(String name) {
        this.name = name;
        return this;
    }

}

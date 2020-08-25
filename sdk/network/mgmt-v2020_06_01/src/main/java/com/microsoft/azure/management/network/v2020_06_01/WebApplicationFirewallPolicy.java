/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.network.v2020_06_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.Resource;
import com.microsoft.azure.arm.resources.models.GroupableResourceCore;
import com.microsoft.azure.arm.resources.models.HasResourceGroup;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.network.v2020_06_01.implementation.NetworkManager;
import java.util.List;
import com.microsoft.azure.SubResource;
import com.microsoft.azure.management.network.v2020_06_01.implementation.WebApplicationFirewallPolicyInner;

/**
 * Type representing WebApplicationFirewallPolicy.
 */
public interface WebApplicationFirewallPolicy extends HasInner<WebApplicationFirewallPolicyInner>, Resource, GroupableResourceCore<NetworkManager, WebApplicationFirewallPolicyInner>, HasResourceGroup, Refreshable<WebApplicationFirewallPolicy>, Updatable<WebApplicationFirewallPolicy.Update>, HasManager<NetworkManager> {
    /**
     * @return the applicationGateways value.
     */
    List<ApplicationGateway> applicationGateways();

    /**
     * @return the customRules value.
     */
    List<WebApplicationFirewallCustomRule> customRules();

    /**
     * @return the etag value.
     */
    String etag();

    /**
     * @return the httpListeners value.
     */
    List<SubResource> httpListeners();

    /**
     * @return the managedRules value.
     */
    ManagedRulesDefinition managedRules();

    /**
     * @return the pathBasedRules value.
     */
    List<SubResource> pathBasedRules();

    /**
     * @return the policySettings value.
     */
    PolicySettings policySettings();

    /**
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * @return the resourceState value.
     */
    WebApplicationFirewallPolicyResourceState resourceState();

    /**
     * The entirety of the WebApplicationFirewallPolicy definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithGroup, DefinitionStages.WithManagedRules, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of WebApplicationFirewallPolicy definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a WebApplicationFirewallPolicy definition.
         */
        interface Blank extends GroupableResourceCore.DefinitionWithRegion<WithGroup> {
        }

        /**
         * The stage of the WebApplicationFirewallPolicy definition allowing to specify the resource group.
         */
        interface WithGroup extends GroupableResourceCore.DefinitionStages.WithGroup<WithManagedRules> {
        }

        /**
         * The stage of the webapplicationfirewallpolicy definition allowing to specify ManagedRules.
         */
        interface WithManagedRules {
           /**
            * Specifies managedRules.
            * @param managedRules Describes the managedRules structure
            * @return the next definition stage
*/
            WithCreate withManagedRules(ManagedRulesDefinition managedRules);
        }

        /**
         * The stage of the webapplicationfirewallpolicy definition allowing to specify CustomRules.
         */
        interface WithCustomRules {
            /**
             * Specifies customRules.
             * @param customRules The custom rules inside the policy
             * @return the next definition stage
             */
            WithCreate withCustomRules(List<WebApplicationFirewallCustomRule> customRules);
        }

        /**
         * The stage of the webapplicationfirewallpolicy definition allowing to specify PolicySettings.
         */
        interface WithPolicySettings {
            /**
             * Specifies policySettings.
             * @param policySettings The PolicySettings for policy
             * @return the next definition stage
             */
            WithCreate withPolicySettings(PolicySettings policySettings);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<WebApplicationFirewallPolicy>, Resource.DefinitionWithTags<WithCreate>, DefinitionStages.WithCustomRules, DefinitionStages.WithPolicySettings {
        }
    }
    /**
     * The template for a WebApplicationFirewallPolicy update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<WebApplicationFirewallPolicy>, Resource.UpdateWithTags<Update>, UpdateStages.WithCustomRules, UpdateStages.WithPolicySettings {
    }

    /**
     * Grouping of WebApplicationFirewallPolicy update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the webapplicationfirewallpolicy update allowing to specify CustomRules.
         */
        interface WithCustomRules {
            /**
             * Specifies customRules.
             * @param customRules The custom rules inside the policy
             * @return the next update stage
             */
            Update withCustomRules(List<WebApplicationFirewallCustomRule> customRules);
        }

        /**
         * The stage of the webapplicationfirewallpolicy update allowing to specify PolicySettings.
         */
        interface WithPolicySettings {
            /**
             * Specifies policySettings.
             * @param policySettings The PolicySettings for policy
             * @return the next update stage
             */
            Update withPolicySettings(PolicySettings policySettings);
        }

    }
}

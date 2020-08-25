/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.network.v2020_06_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.network.v2020_06_01.ResourceNavigationLinks;
import rx.functions.Func1;
import rx.Observable;
import com.microsoft.azure.management.network.v2020_06_01.ResourceNavigationLinksListResult;

class ResourceNavigationLinksImpl extends WrapperImpl<ResourceNavigationLinksInner> implements ResourceNavigationLinks {
    private final NetworkManager manager;

    ResourceNavigationLinksImpl(NetworkManager manager) {
        super(manager.inner().resourceNavigationLinks());
        this.manager = manager;
    }

    public NetworkManager manager() {
        return this.manager;
    }

    @Override
    public Observable<ResourceNavigationLinksListResult> listAsync(String resourceGroupName, String virtualNetworkName, String subnetName) {
        ResourceNavigationLinksInner client = this.inner();
        return client.listAsync(resourceGroupName, virtualNetworkName, subnetName)
        .map(new Func1<ResourceNavigationLinksListResultInner, ResourceNavigationLinksListResult>() {
            @Override
            public ResourceNavigationLinksListResult call(ResourceNavigationLinksListResultInner inner) {
                return new ResourceNavigationLinksListResultImpl(inner, manager());
            }
        });
    }

}

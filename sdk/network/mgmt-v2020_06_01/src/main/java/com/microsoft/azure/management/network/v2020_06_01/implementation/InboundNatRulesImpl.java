/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.network.v2020_06_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.network.v2020_06_01.InboundNatRules;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.network.v2020_06_01.InboundNatRule;

class InboundNatRulesImpl extends WrapperImpl<InboundNatRulesInner> implements InboundNatRules {
    private final NetworkManager manager;

    InboundNatRulesImpl(NetworkManager manager) {
        super(manager.inner().inboundNatRules());
        this.manager = manager;
    }

    public NetworkManager manager() {
        return this.manager;
    }

    @Override
    public InboundNatRuleImpl define(String name) {
        return wrapModel(name);
    }

    private InboundNatRuleImpl wrapModel(InboundNatRuleInner inner) {
        return  new InboundNatRuleImpl(inner, manager());
    }

    private InboundNatRuleImpl wrapModel(String name) {
        return new InboundNatRuleImpl(name, this.manager());
    }

    @Override
    public Observable<InboundNatRule> listAsync(final String resourceGroupName, final String loadBalancerName) {
        InboundNatRulesInner client = this.inner();
        return client.listAsync(resourceGroupName, loadBalancerName)
        .flatMapIterable(new Func1<Page<InboundNatRuleInner>, Iterable<InboundNatRuleInner>>() {
            @Override
            public Iterable<InboundNatRuleInner> call(Page<InboundNatRuleInner> page) {
                return page.items();
            }
        })
        .map(new Func1<InboundNatRuleInner, InboundNatRule>() {
            @Override
            public InboundNatRule call(InboundNatRuleInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<InboundNatRule> getAsync(String resourceGroupName, String loadBalancerName, String inboundNatRuleName) {
        InboundNatRulesInner client = this.inner();
        return client.getAsync(resourceGroupName, loadBalancerName, inboundNatRuleName)
        .flatMap(new Func1<InboundNatRuleInner, Observable<InboundNatRule>>() {
            @Override
            public Observable<InboundNatRule> call(InboundNatRuleInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((InboundNatRule)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String loadBalancerName, String inboundNatRuleName) {
        InboundNatRulesInner client = this.inner();
        return client.deleteAsync(resourceGroupName, loadBalancerName, inboundNatRuleName).toCompletable();
    }

}

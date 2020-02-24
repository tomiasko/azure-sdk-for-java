/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * jkl
 */

package com.microsoft.azure.management.policy.v2019_09_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.policy.v2019_09_01.PolicyAssignments;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.policy.v2019_09_01.PolicyAssignment;
import com.microsoft.azure.arm.utils.PagedListConverter;

class PolicyAssignmentsImpl extends WrapperImpl<PolicyAssignmentsInner> implements PolicyAssignments {
    private PagedListConverter<PolicyAssignmentInner, PolicyAssignment> converter;
    private final PolicyManager manager;

    PolicyAssignmentsImpl(PolicyManager manager) {
        super(manager.inner().policyAssignments());
        this.manager = manager;
        this.converter = new PagedListConverter<PolicyAssignmentInner, PolicyAssignment>() {
            @Override
            public Observable<PolicyAssignment> typeConvertAsync(PolicyAssignmentInner inner) {
                return Observable.just((PolicyAssignment) wrapModel(inner));
            }
        };
    }

    public PolicyManager manager() {
        return this.manager;
    }

    @Override
    public PolicyAssignmentImpl define(String name) {
        return wrapModel(name);
    }

    private PolicyAssignmentImpl wrapModel(PolicyAssignmentInner inner) {
        return  new PolicyAssignmentImpl(inner, manager());
    }

    private PolicyAssignmentImpl wrapModel(String name) {
        return new PolicyAssignmentImpl(name, this.manager());
    }

    @Override
    public Observable<PolicyAssignment> deleteAsync(String scope, String policyAssignmentName) {
        PolicyAssignmentsInner client = this.inner();
        return client.deleteAsync(scope, policyAssignmentName)
        .map(new Func1<PolicyAssignmentInner, PolicyAssignment>() {
            @Override
            public PolicyAssignment call(PolicyAssignmentInner inner) {
                return new PolicyAssignmentImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<PolicyAssignment> getAsync(String scope, String policyAssignmentName) {
        PolicyAssignmentsInner client = this.inner();
        return client.getAsync(scope, policyAssignmentName)
        .map(new Func1<PolicyAssignmentInner, PolicyAssignment>() {
            @Override
            public PolicyAssignment call(PolicyAssignmentInner inner) {
                return new PolicyAssignmentImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<PolicyAssignment> listForResourceAsync(final String resourceGroupName, final String resourceProviderNamespace, final String parentResourcePath, final String resourceType, final String resourceName) {
        PolicyAssignmentsInner client = this.inner();
        return client.listForResourceAsync(resourceGroupName, resourceProviderNamespace, parentResourcePath, resourceType, resourceName)
        .flatMapIterable(new Func1<Page<PolicyAssignmentInner>, Iterable<PolicyAssignmentInner>>() {
            @Override
            public Iterable<PolicyAssignmentInner> call(Page<PolicyAssignmentInner> page) {
                return page.items();
            }
        })
        .map(new Func1<PolicyAssignmentInner, PolicyAssignment>() {
            @Override
            public PolicyAssignment call(PolicyAssignmentInner inner) {
                return new PolicyAssignmentImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<PolicyAssignment> listForManagementGroupAsync(final String managementGroupId, final String filter) {
        PolicyAssignmentsInner client = this.inner();
        return client.listForManagementGroupAsync(managementGroupId, filter)
        .flatMapIterable(new Func1<Page<PolicyAssignmentInner>, Iterable<PolicyAssignmentInner>>() {
            @Override
            public Iterable<PolicyAssignmentInner> call(Page<PolicyAssignmentInner> page) {
                return page.items();
            }
        })
        .map(new Func1<PolicyAssignmentInner, PolicyAssignment>() {
            @Override
            public PolicyAssignment call(PolicyAssignmentInner inner) {
                return new PolicyAssignmentImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<PolicyAssignment> deleteByIdAsync(String policyAssignmentId) {
        PolicyAssignmentsInner client = this.inner();
        return client.deleteByIdAsync(policyAssignmentId)
        .map(new Func1<PolicyAssignmentInner, PolicyAssignment>() {
            @Override
            public PolicyAssignment call(PolicyAssignmentInner inner) {
                return new PolicyAssignmentImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<PolicyAssignment> createByIdAsync(String policyAssignmentId, PolicyAssignmentInner parameters) {
        PolicyAssignmentsInner client = this.inner();
        return client.createByIdAsync(policyAssignmentId, parameters)
        .map(new Func1<PolicyAssignmentInner, PolicyAssignment>() {
            @Override
            public PolicyAssignment call(PolicyAssignmentInner inner) {
                return new PolicyAssignmentImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<PolicyAssignment> getByIdAsync(String policyAssignmentId) {
        PolicyAssignmentsInner client = this.inner();
        return client.getByIdAsync(policyAssignmentId)
        .map(new Func1<PolicyAssignmentInner, PolicyAssignment>() {
            @Override
            public PolicyAssignment call(PolicyAssignmentInner inner) {
                return new PolicyAssignmentImpl(inner, manager());
            }
        });
    }

    @Override
    public PagedList<PolicyAssignment> list() {
        PolicyAssignmentsInner client = this.inner();
        return converter.convert(client.list());
    }

    @Override
    public Observable<PolicyAssignment> listAsync() {
        PolicyAssignmentsInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<PolicyAssignmentInner>, Iterable<PolicyAssignmentInner>>() {
            @Override
            public Iterable<PolicyAssignmentInner> call(Page<PolicyAssignmentInner> page) {
                return page.items();
            }
        })
        .map(new Func1<PolicyAssignmentInner, PolicyAssignment>() {
            @Override
            public PolicyAssignment call(PolicyAssignmentInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<PolicyAssignment> listByResourceGroup(String resourceGroupName) {
        PolicyAssignmentsInner client = this.inner();
        return converter.convert(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<PolicyAssignment> listByResourceGroupAsync(String resourceGroupName) {
        PolicyAssignmentsInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<PolicyAssignmentInner>, Iterable<PolicyAssignmentInner>>() {
            @Override
            public Iterable<PolicyAssignmentInner> call(Page<PolicyAssignmentInner> page) {
                return page.items();
            }
        })
        .map(new Func1<PolicyAssignmentInner, PolicyAssignment>() {
            @Override
            public PolicyAssignment call(PolicyAssignmentInner inner) {
                return wrapModel(inner);
            }
        });
    }

}
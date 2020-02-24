/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.automation.v2018_06_30.implementation;

import com.microsoft.azure.management.automation.v2018_06_30.Module;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import rx.Observable;
import com.microsoft.azure.management.automation.v2018_06_30.PythonPackageCreateParameters;
import java.util.Map;
import com.microsoft.azure.management.automation.v2018_06_30.ContentLink;
import org.joda.time.DateTime;
import com.microsoft.azure.management.automation.v2018_06_30.ModuleErrorInfo;
import com.microsoft.azure.management.automation.v2018_06_30.ModuleProvisioningState;
import rx.functions.Func1;

class ModuleImpl extends CreatableUpdatableImpl<Module, ModuleInner, ModuleImpl> implements Module, Module.Definition, Module.Update {
    private final AutomationManager manager;
    private String resourceGroupName;
    private String automationAccountName;
    private String packageName;
    private PythonPackageCreateParameters createOrUpdateParameter;

    ModuleImpl(String name, AutomationManager manager) {
        super(name, new ModuleInner());
        this.manager = manager;
        // Set resource name
        this.packageName = name;
        //
        this.createOrUpdateParameter = new PythonPackageCreateParameters();
    }

    ModuleImpl(ModuleInner inner, AutomationManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.packageName = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.automationAccountName = IdParsingUtils.getValueFromIdByName(inner.id(), "automationAccounts");
        this.packageName = IdParsingUtils.getValueFromIdByName(inner.id(), "python2Packages");
        //
        this.createOrUpdateParameter = new PythonPackageCreateParameters();
    }

    @Override
    public AutomationManager manager() {
        return this.manager;
    }

    @Override
    public Observable<Module> createResourceAsync() {
        Python2PackagesInner client = this.manager().inner().python2Packages();
        return client.createOrUpdateAsync(this.resourceGroupName, this.automationAccountName, this.packageName, this.createOrUpdateParameter)
            .map(new Func1<ModuleInner, ModuleInner>() {
               @Override
               public ModuleInner call(ModuleInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<Module> updateResourceAsync() {
        Python2PackagesInner client = this.manager().inner().python2Packages();
        return client.createOrUpdateAsync(this.resourceGroupName, this.automationAccountName, this.packageName, this.createOrUpdateParameter)
            .map(new Func1<ModuleInner, ModuleInner>() {
               @Override
               public ModuleInner call(ModuleInner resource) {
                   resetCreateUpdateParameters();
                   return resource;
               }
            })
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<ModuleInner> getInnerAsync() {
        Python2PackagesInner client = this.manager().inner().python2Packages();
        return client.getAsync(this.resourceGroupName, this.automationAccountName, this.packageName);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }

    private void resetCreateUpdateParameters() {
        this.createOrUpdateParameter = new PythonPackageCreateParameters();
    }

    @Override
    public Integer activityCount() {
        return this.inner().activityCount();
    }

    @Override
    public ContentLink contentLink() {
        return this.inner().contentLink();
    }

    @Override
    public DateTime creationTime() {
        return this.inner().creationTime();
    }

    @Override
    public String description() {
        return this.inner().description();
    }

    @Override
    public ModuleErrorInfo error() {
        return this.inner().error();
    }

    @Override
    public String etag() {
        return this.inner().etag();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public Boolean isComposite() {
        return this.inner().isComposite();
    }

    @Override
    public Boolean isGlobal() {
        return this.inner().isGlobal();
    }

    @Override
    public DateTime lastModifiedTime() {
        return this.inner().lastModifiedTime();
    }

    @Override
    public String location() {
        return this.inner().location();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public ModuleProvisioningState provisioningState() {
        return this.inner().provisioningState();
    }

    @Override
    public Long sizeInBytes() {
        return this.inner().sizeInBytes();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public String version() {
        return this.inner().version();
    }

    @Override
    public ModuleImpl withExistingAutomationAccount(String resourceGroupName, String automationAccountName) {
        this.resourceGroupName = resourceGroupName;
        this.automationAccountName = automationAccountName;
        return this;
    }

    @Override
    public ModuleImpl withContentLink(ContentLink contentLink) {
        this.createOrUpdateParameter.withContentLink(contentLink);
        return this;
    }

    @Override
    public ModuleImpl withTags(Map<String, String> tags) {
        this.createOrUpdateParameter.withTags(tags);
        return this;
    }

}
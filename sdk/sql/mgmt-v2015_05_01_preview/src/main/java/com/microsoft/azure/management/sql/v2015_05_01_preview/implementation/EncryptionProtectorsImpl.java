/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.sql.v2015_05_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.sql.v2015_05_01_preview.EncryptionProtectors;
import rx.functions.Func1;
import rx.Observable;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.sql.v2015_05_01_preview.EncryptionProtector;

class EncryptionProtectorsImpl extends WrapperImpl<EncryptionProtectorsInner> implements EncryptionProtectors {
    private final SqlManager manager;

    EncryptionProtectorsImpl(SqlManager manager) {
        super(manager.inner().encryptionProtectors());
        this.manager = manager;
    }

    public SqlManager manager() {
        return this.manager;
    }

    @Override
    public Observable<EncryptionProtector> listByServerAsync(final String resourceGroupName, final String serverName) {
        EncryptionProtectorsInner client = this.inner();
        return client.listByServerAsync(resourceGroupName, serverName)
        .flatMapIterable(new Func1<Page<EncryptionProtectorInner>, Iterable<EncryptionProtectorInner>>() {
            @Override
            public Iterable<EncryptionProtectorInner> call(Page<EncryptionProtectorInner> page) {
                return page.items();
            }
        })
        .map(new Func1<EncryptionProtectorInner, EncryptionProtector>() {
            @Override
            public EncryptionProtector call(EncryptionProtectorInner inner) {
                return new EncryptionProtectorImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<EncryptionProtector> getAsync(String resourceGroupName, String serverName) {
        EncryptionProtectorsInner client = this.inner();
        return client.getAsync(resourceGroupName, serverName)
        .map(new Func1<EncryptionProtectorInner, EncryptionProtector>() {
            @Override
            public EncryptionProtector call(EncryptionProtectorInner inner) {
                return new EncryptionProtectorImpl(inner, manager());
            }
        });
    }

    @Override
    public Observable<EncryptionProtector> createOrUpdateAsync(String resourceGroupName, String serverName, EncryptionProtectorInner parameters) {
        EncryptionProtectorsInner client = this.inner();
        return client.createOrUpdateAsync(resourceGroupName, serverName, parameters)
        .map(new Func1<EncryptionProtectorInner, EncryptionProtector>() {
            @Override
            public EncryptionProtector call(EncryptionProtectorInner inner) {
                return new EncryptionProtectorImpl(inner, manager());
            }
        });
    }

}
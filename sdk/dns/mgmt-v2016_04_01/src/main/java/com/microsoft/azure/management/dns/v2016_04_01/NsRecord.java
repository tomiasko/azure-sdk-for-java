/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.dns.v2016_04_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An NS record.
 */
public class NsRecord {
    /**
     * The name server name for this NS record.
     */
    @JsonProperty(value = "nsdname")
    private String nsdname;

    /**
     * Get the nsdname value.
     *
     * @return the nsdname value
     */
    public String nsdname() {
        return this.nsdname;
    }

    /**
     * Set the nsdname value.
     *
     * @param nsdname the nsdname value to set
     * @return the NsRecord object itself.
     */
    public NsRecord withNsdname(String nsdname) {
        this.nsdname = nsdname;
        return this;
    }

}
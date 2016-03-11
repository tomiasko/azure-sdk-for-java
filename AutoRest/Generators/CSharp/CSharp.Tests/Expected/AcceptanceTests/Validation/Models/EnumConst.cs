// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for
// license information.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is
// regenerated.

namespace Fixtures.AcceptanceTestsValidation.Models
{
    using Newtonsoft.Json;
    using Newtonsoft.Json.Converters;
    using System.Runtime.Serialization;

    /// <summary>
    /// Defines values for EnumConst.
    /// </summary>
    [JsonConverter(typeof(StringEnumConverter))]
    public enum EnumConst
    {
        [EnumMember(Value = "constant_string_as_enum")]
        ConstantStringAsEnum
    }
}

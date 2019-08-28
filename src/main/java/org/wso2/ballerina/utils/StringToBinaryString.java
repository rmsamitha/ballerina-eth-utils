/*
*   Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package org.wso2.ballerina.utils;

import org.ballerinalang.bre.Context;
import org.ballerinalang.bre.bvm.BlockingNativeCallableUnit;
import org.ballerinalang.model.types.TypeKind;
import org.ballerinalang.model.values.BString;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;

/**
 * Native function wso2.ballerina.util:stringToBinaryString.
 */
@BallerinaFunction(
        orgName = "wso2",
        packageName = "utils:0.0.1",
        functionName = "stringToBinaryString",
        args = {@Argument(name = "a", type = TypeKind.STRING)},
        returnType = {@ReturnType(type = TypeKind.STRING)},
        isPublic = true
)
public class StringToBinaryString extends BlockingNativeCallableUnit {

    @Override
    public void execute(Context context) {
        String v = (String) context.getStringArgument(0);
        char[] arr = v.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            sb.append((int)arr[i]);
            sb.append(",");
        }

        BString returnVal = new BString(String.valueOf(sb.toString()));
        context.setReturnValues(returnVal);
    }
}
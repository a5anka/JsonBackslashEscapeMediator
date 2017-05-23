/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.synapse.mediators.custom.json;

import org.apache.axis2.AxisFault;
import org.apache.synapse.MessageContext;
import org.apache.synapse.SynapseException;
import org.apache.synapse.commons.json.JsonUtil;
import org.apache.synapse.core.axis2.Axis2MessageContext;
import org.apache.synapse.mediators.AbstractMediator;

/**
 * Escape backslash '\' in the JSON payload
 */
public class JsonBackslashEscapeMediator extends AbstractMediator {

    public boolean mediate(MessageContext messageContext) {
        org.apache.axis2.context.MessageContext axis2MessageContext
                = ((Axis2MessageContext) messageContext).getAxis2MessageContext();

        if (JsonUtil.hasAJsonObject(axis2MessageContext)) {
            String jsonPayloadToString = JsonUtil.jsonPayloadToString(axis2MessageContext);

            String newStr = jsonPayloadToString.replace("\\", "\\\\");

            try {
                JsonUtil.getNewJsonPayload(axis2MessageContext, newStr,true,true);
            } catch (AxisFault axisFault) {
                throw new SynapseException("Error occurred while processing json payload", axisFault);
            }
        }

        return true;
    }
}

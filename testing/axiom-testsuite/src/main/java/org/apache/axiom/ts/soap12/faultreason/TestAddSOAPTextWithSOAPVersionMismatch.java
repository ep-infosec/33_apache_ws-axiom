/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.axiom.ts.soap12.faultreason;

import org.apache.axiom.om.OMMetaFactory;
import org.apache.axiom.soap.SOAPFault;
import org.apache.axiom.soap.SOAPFaultReason;
import org.apache.axiom.ts.soap.SOAPSpec;
import org.apache.axiom.ts.soap.SOAPTestCase;

public class TestAddSOAPTextWithSOAPVersionMismatch extends SOAPTestCase {
    public TestAddSOAPTextWithSOAPVersionMismatch(OMMetaFactory metaFactory) {
        super(metaFactory, SOAPSpec.SOAP12);
    }

    @Override
    protected void runTest() throws Throwable {
        SOAPFault soap12Fault = soapFactory.createSOAPFault();
        SOAPFaultReason soap12FaultReason = soapFactory.createSOAPFaultReason(soap12Fault);
        SOAPFault soap11Fault = altSoapFactory.createSOAPFault();
        SOAPFaultReason soap11FaultReason = altSoapFactory.createSOAPFaultReason(soap11Fault);
        try {
            soap12FaultReason.addSOAPText(altSoapFactory.createSOAPFaultText(soap11FaultReason));
            fail("SOAP11FaultText should not be added to SOAP12FaultReason");
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}

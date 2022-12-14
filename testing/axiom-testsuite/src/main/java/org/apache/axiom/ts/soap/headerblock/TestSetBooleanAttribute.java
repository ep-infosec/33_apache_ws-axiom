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
package org.apache.axiom.ts.soap.headerblock;

import java.util.Iterator;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMMetaFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.soap.SOAPHeaderBlock;
import org.apache.axiom.ts.soap.HeaderBlockAttribute;
import org.apache.axiom.ts.soap.BooleanAttributeAccessor;
import org.apache.axiom.ts.soap.SOAPSpec;

public class TestSetBooleanAttribute extends BooleanAttributeTestCase {
    private final boolean value;

    public TestSetBooleanAttribute(
            OMMetaFactory metaFactory,
            SOAPSpec spec,
            HeaderBlockAttribute attribute,
            boolean value) {
        super(metaFactory, spec, attribute);
        addTestParameter("value", value);
        this.value = value;
    }

    @Override
    protected void runTest() throws Throwable {
        SOAPHeaderBlock soapHeaderBlock = createSOAPHeaderBlock();
        BooleanAttributeAccessor accessor = attribute.getAdapter(BooleanAttributeAccessor.class);
        accessor.setValue(soapHeaderBlock, value);
        assertEquals(value, accessor.getValue(soapHeaderBlock));
        Iterator<OMAttribute> it = soapHeaderBlock.getAllAttributes();
        assertTrue(it.hasNext());
        OMAttribute att = it.next();
        OMNamespace ns = att.getNamespace();
        assertEquals(spec.getEnvelopeNamespaceURI(), ns.getNamespaceURI());
        assertEquals(attribute.getName(spec), att.getLocalName());
        assertEquals(spec.getCanonicalRepresentation(value), att.getAttributeValue());
        assertFalse(it.hasNext());
    }
}

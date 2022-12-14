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
package org.apache.axiom.ts.om.element;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAttribute;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMMetaFactory;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axiom.ts.AxiomTestCase;

/**
 * Test that {@link OMElement#getAttribute(QName)} works properly for an attribute with the {@code
 * xml} prefix, even if this prefix is not declared explicitly. This is a regression test for <a
 * href="https://issues.apache.org/jira/browse/AXIS2-329">AXIS2-329</a>.
 */
public class TestGetAttributeWithXmlPrefix2 extends AxiomTestCase {
    public TestGetAttributeWithXmlPrefix2(OMMetaFactory metaFactory) {
        super(metaFactory);
    }

    @Override
    protected void runTest() throws Throwable {
        OMElement elem =
                AXIOMUtil.stringToOM(
                        metaFactory.getOMFactory(), "<Policy xml:base=\"uri:thisBase\"></Policy>");
        OMAttribute attr = elem.getAttribute(new QName(XMLConstants.XML_NS_URI, "base"));
        assertEquals(
                "Attribute namespace mismatch",
                XMLConstants.XML_NS_URI,
                attr.getNamespace().getNamespaceURI());
    }
}

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
package org.apache.axiom.ts.om.sourcedelement;

import org.apache.axiom.om.OMDataSource;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMMetaFactory;
import org.apache.axiom.om.OMSourcedElement;
import org.apache.axiom.om.OMXMLParserWrapper;
import org.apache.axiom.om.ds.StringOMDataSource;
import org.apache.axiom.ts.AxiomTestCase;

/**
 * Tests that {@link OMXMLParserWrapper#getDocument()} and {@link
 * OMXMLParserWrapper#getDocumentElement()} throw {@link UnsupportedOperationException} when invoked
 * on the builder associated with an {@link OMSourcedElement}.
 */
public class TestGetDocumentFromBuilder extends AxiomTestCase {
    public TestGetDocumentFromBuilder(OMMetaFactory metaFactory) {
        super(metaFactory);
    }

    @Override
    protected void runTest() throws Throwable {
        OMFactory factory = metaFactory.getOMFactory();
        OMDataSource ds = new StringOMDataSource("<root><a/></root>");
        OMSourcedElement element = factory.createOMElement(ds);
        // Force expansion
        element.getFirstOMChild();
        OMXMLParserWrapper builder = element.getBuilder();
        try {
            builder.getDocument();
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException ex) {
            // Expected
        }
        try {
            builder.getDocumentElement();
            fail("Expected UnsupportedOperationException");
        } catch (UnsupportedOperationException ex) {
            // Expected
        }
    }
}

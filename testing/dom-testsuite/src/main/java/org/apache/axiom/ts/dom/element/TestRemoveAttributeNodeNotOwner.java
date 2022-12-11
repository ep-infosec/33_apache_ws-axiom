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
package org.apache.axiom.ts.dom.element;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.axiom.ts.dom.DOMTestCase;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Tests the behavior of {@link Element#removeAttributeNode(Attr)} if the given attribute is not
 * owned by the element.
 */
public class TestRemoveAttributeNodeNotOwner extends DOMTestCase {
    public TestRemoveAttributeNodeNotOwner(DocumentBuilderFactory dbf) {
        super(dbf);
    }

    @Override
    protected void runTest() throws Throwable {
        Document document = dbf.newDocumentBuilder().newDocument();
        Element element1 = document.createElementNS(null, "test");
        Attr attr1 = document.createAttributeNS(null, "attr");
        element1.setAttributeNodeNS(attr1);
        Element element2 = document.createElementNS(null, "test");
        Attr attr2 = document.createAttributeNS(null, "attr");
        element2.setAttributeNodeNS(attr2);
        try {
            element1.removeAttributeNode(attr2);
            fail("Expected DOMException");
        } catch (DOMException ex) {
            assertEquals(DOMException.NOT_FOUND_ERR, ex.code);
        }
    }
}

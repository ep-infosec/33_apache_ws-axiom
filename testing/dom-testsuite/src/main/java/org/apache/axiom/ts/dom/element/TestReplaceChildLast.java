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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Tests the behavior of {@link Node#replaceChild(Node, Node)}. This test covers the case where the
 * child being replaced is the last child (which uses a different code path in DOOM).
 */
public class TestReplaceChildLast extends ReplaceChildTestCase {
    public TestReplaceChildLast(DocumentBuilderFactory dbf, boolean newChildHasSiblings) {
        super(dbf, newChildHasSiblings);
    }

    @Override
    protected void runTest(Document doc, Node newChild) {
        Element parent = doc.createElementNS(null, "parent");
        Element child1 = doc.createElementNS(null, "child1");
        Element child2 = doc.createElementNS(null, "child2");
        parent.appendChild(child1);
        parent.appendChild(child2);
        parent.replaceChild(newChild, child2);
        assertSame(child1, parent.getFirstChild());
        assertSame(newChild, parent.getLastChild());
        assertSame(child1, newChild.getPreviousSibling());
        assertNull(newChild.getNextSibling());
        assertSame(newChild, child1.getNextSibling());
        NodeList children = parent.getChildNodes();
        assertEquals(2, children.getLength());
        assertSame(child1, children.item(0));
        assertSame(newChild, children.item(1));
    }
}

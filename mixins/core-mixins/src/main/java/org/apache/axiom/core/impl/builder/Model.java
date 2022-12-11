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
package org.apache.axiom.core.impl.builder;

import org.apache.axiom.core.CoreDocument;
import org.apache.axiom.core.CoreNSAwareElement;
import org.apache.axiom.core.CoreParentNode;

public interface Model {
    /**
     * Create the document node suitable for this model.
     *
     * @return the document node, or {@code null} if a plain {@link CoreDocument} should be used
     */
    CoreDocument createDocument();

    /**
     * Create a model specific element node. The implementation must only create the element, but
     * not set any of its properties.
     *
     * @param parent the parent for the element
     * @param elementName the local name for the element
     * @return the element node, or {@code null} if a plain {@link CoreNSAwareElement} should be
     *     used
     */
    CoreNSAwareElement createElement(
            CoreParentNode parent, int elementLevel, String namespaceURI, String localName);
}

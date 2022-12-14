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
package org.apache.axiom.core;

import org.apache.axiom.weaver.annotation.FactoryMethod;
import org.apache.axiom.weaver.annotation.Singleton;

// TODO: this should be fused into NodeFactory
@Singleton
public interface NodeFactory2 {
    @FactoryMethod
    CoreDocument createDocument();

    @FactoryMethod
    CoreDocumentTypeDeclaration createDocumentTypeDeclaration();

    @FactoryMethod
    CoreNSAwareElement createNSAwareElement();

    @FactoryMethod
    CoreNSUnawareElement createNSUnawareElement();

    @FactoryMethod
    CoreNSAwareAttribute createNSAwareAttribute();

    @FactoryMethod
    CoreNSUnawareAttribute createNSUnawareAttribute();

    @FactoryMethod
    CoreNamespaceDeclaration createNamespaceDeclaration();

    @FactoryMethod
    CoreCharacterDataNode createCharacterDataNode();

    @FactoryMethod
    CoreProcessingInstruction createProcessingInstruction();

    @FactoryMethod
    CoreComment createComment();

    @FactoryMethod
    CoreCDATASection createCDATASection();

    @FactoryMethod
    CoreEntityReference createEntityReference();

    /**
     * Create the namespace helper object that will be passed to {@link
     * CoreNSAwareNamedNode#initName(String, String, String, Object)}.
     *
     * @return the namespace helper
     */
    Object createNamespaceHelper();
}

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
package org.apache.axiom.core.impl.mixin;

import org.apache.axiom.core.ClonePolicy;
import org.apache.axiom.core.CoreDocument;
import org.apache.axiom.core.CoreDocumentFragment;
import org.apache.axiom.core.CoreModelException;
import org.apache.axiom.core.CoreNode;
import org.apache.axiom.core.NodeType;
import org.apache.axiom.core.stream.StreamException;
import org.apache.axiom.core.stream.XmlHandler;
import org.apache.axiom.weaver.annotation.Mixin;

@Mixin
public abstract class CoreDocumentFragmentMixin implements CoreDocumentFragment {
    private CoreDocument ownerDocument;

    @Override
    public final NodeType coreGetNodeType() {
        return NodeType.DOCUMENT_FRAGMENT;
    }

    @Override
    public final CoreNode getRootOrOwnerDocument() {
        if (ownerDocument == null) {
            return this;
        } else {
            return ownerDocument;
        }
    }

    @Override
    public final void coreSetOwnerDocument(CoreDocument document) {
        ownerDocument = document;
    }

    @Override
    public final <T> void init(ClonePolicy<T> policy, T options, CoreNode other) {}

    @Override
    public final void internalSerialize(XmlHandler handler, boolean cache)
            throws CoreModelException, StreamException {
        // TODO
        throw new UnsupportedOperationException();
    }
}

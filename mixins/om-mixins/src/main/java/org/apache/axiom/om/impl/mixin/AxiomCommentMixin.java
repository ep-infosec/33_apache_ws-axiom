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
package org.apache.axiom.om.impl.mixin;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.axiom.core.CoreModelException;
import org.apache.axiom.om.OMNode;
import org.apache.axiom.om.impl.common.AxiomExceptionTranslator;
import org.apache.axiom.om.impl.common.AxiomSemantics;
import org.apache.axiom.om.impl.intf.AxiomComment;
import org.apache.axiom.weaver.annotation.Mixin;

@Mixin
public abstract class AxiomCommentMixin implements AxiomComment {
    @Override
    public final int getType() {
        return OMNode.COMMENT_NODE;
    }

    @Override
    public String getValue() {
        try {
            return coreGetCharacterData().toString();
        } catch (CoreModelException ex) {
            throw AxiomExceptionTranslator.translate(ex);
        }
    }

    @Override
    public void setValue(String text) {
        try {
            coreSetCharacterData(text, AxiomSemantics.INSTANCE);
        } catch (CoreModelException ex) {
            throw AxiomExceptionTranslator.translate(ex);
        }
    }

    @Override
    public final void serialize(XMLStreamWriter writer, boolean cache) throws XMLStreamException {
        try {
            writer.writeComment(coreGetCharacterData().toString());
        } catch (CoreModelException ex) {
            throw AxiomExceptionTranslator.translate(ex);
        }
    }

    @Override
    public final void buildWithAttachments() {}
}

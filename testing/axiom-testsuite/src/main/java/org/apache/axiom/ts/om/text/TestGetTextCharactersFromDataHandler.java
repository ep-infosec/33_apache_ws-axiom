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
package org.apache.axiom.ts.om.text;

import javax.activation.DataHandler;

import org.apache.axiom.om.OMMetaFactory;
import org.apache.axiom.om.OMText;
import org.apache.axiom.testutils.activation.TextDataSource;
import org.apache.axiom.ts.AxiomTestCase;
import org.apache.axiom.util.activation.DataHandlerUtils;
import org.apache.commons.codec.binary.Base64;

/**
 * Tests that {@link OMText#getTextCharacters()} returns the expected result for an {@link OMText}
 * node backed by a {@link DataHandler}. This is a regression test for <a
 * href="https://issues.apache.org/jira/browse/AXIOM-442">AXIOM-442</a>.
 */
public class TestGetTextCharactersFromDataHandler extends AxiomTestCase {
    public TestGetTextCharactersFromDataHandler(OMMetaFactory metaFactory) {
        super(metaFactory);
    }

    @Override
    protected void runTest() throws Throwable {
        DataHandler dh = new DataHandler(new TextDataSource("test content", "utf-8", "plain"));
        OMText text = metaFactory.getOMFactory().createOMText(DataHandlerUtils.toBlob(dh), true);
        char[] chars = text.getTextCharacters();
        byte[] decoded = Base64.decodeBase64(new String(chars));
        assertEquals("test content", new String(decoded, "utf-8"));
    }
}

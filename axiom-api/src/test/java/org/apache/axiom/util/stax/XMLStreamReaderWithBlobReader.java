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
package org.apache.axiom.util.stax;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.apache.axiom.blob.Blob;
import org.apache.axiom.ext.stax.BlobProvider;
import org.apache.axiom.ext.stax.BlobReader;
import org.apache.axiom.util.stax.wrapper.XMLStreamReaderWrapper;

public class XMLStreamReaderWithBlobReader extends XMLStreamReaderWrapper implements BlobReader {
    public XMLStreamReaderWithBlobReader(XMLStreamReader parent) {
        super(parent);
    }

    @Override
    public Object getProperty(String name) throws IllegalArgumentException {
        Object value = XMLStreamReaderUtils.processGetProperty(this, name);
        return value != null ? value : super.getProperty(name);
    }

    @Override
    public boolean isBinary() {
        return false;
    }

    @Override
    public boolean isOptimized() {
        throw new IllegalStateException();
    }

    @Override
    public boolean isDeferred() {
        throw new IllegalStateException();
    }

    @Override
    public String getContentID() {
        throw new IllegalStateException();
    }

    @Override
    public Blob getBlob() throws XMLStreamException {
        throw new IllegalStateException();
    }

    @Override
    public BlobProvider getBlobProvider() {
        throw new IllegalStateException();
    }
}

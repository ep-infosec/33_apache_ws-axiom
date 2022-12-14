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
package org.apache.axiom.ts.om.factory;

import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMMetaFactory;
import org.apache.axiom.ts.AxiomTestCase;

/**
 * Base class for the test cases that validate the behavior of the various <code>createOMElement
 * </code> methods in {@link OMFactory}.
 */
public abstract class CreateOMElementTestCase extends AxiomTestCase {
    protected final CreateOMElementVariant variant;
    protected final CreateOMElementParentSupplier parentSupplier;

    public CreateOMElementTestCase(
            OMMetaFactory metaFactory,
            CreateOMElementVariant variant,
            CreateOMElementParentSupplier parentSupplier) {
        super(metaFactory);
        this.variant = variant;
        this.parentSupplier = parentSupplier;
        addTestParameter("variant", variant.getName());
        if (parentSupplier != null) {
            addTestParameter("parent", parentSupplier.getName());
        }
    }
}

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
package org.apache.axiom.weaver.tree;

import static com.google.common.truth.Truth.assertThat;

import org.apache.axiom.weaver.SimpleImplementationClassNameMapper;
import org.apache.axiom.weaver.Weaver;
import org.junit.jupiter.api.Test;

public class TreeTest {
    @Test
    public void testInnerclass() throws Exception {
        ClassLoader cl = TreeTest.class.getClassLoader();
        Weaver weaver = new Weaver(cl, new SimpleImplementationClassNameMapper("impl"));
        weaver.addInterfaceToImplement(Root.class);
        weaver.addInterfaceToImplement(Directory.class);
        weaver.addInterfaceToImplement(Leaf.class);
        weaver.addInterfaceToImplement(Factory.class);
        Factory factory =
                (Factory)
                        weaver.toClassLoader(cl)
                                .loadClass("impl.FactoryImpl")
                                .getField("INSTANCE")
                                .get(null);
        Root root = factory.createRoot();
        assertThat(root.getFactory()).isSameInstanceAs(factory);
    }
}

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

package org.apache.axiom.test.jaxen;

import java.util.Iterator;

import org.jaxen.FunctionCallException;
import org.jaxen.Navigator;
import org.jaxen.UnsupportedAxisException;
import org.jaxen.XPath;
import org.jaxen.saxpath.SAXPathException;

public class NavigatorWrapper implements Navigator {
    private final Navigator parent;

    @Override
    public Iterator getAncestorAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getAncestorAxisIterator(arg0);
    }

    @Override
    public Iterator getAncestorOrSelfAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getAncestorOrSelfAxisIterator(arg0);
    }

    @Override
    public Iterator getAttributeAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getAttributeAxisIterator(arg0);
    }

    @Override
    public String getAttributeName(Object arg0) {
        return parent.getAttributeName(arg0);
    }

    @Override
    public String getAttributeNamespaceUri(Object arg0) {
        return parent.getAttributeNamespaceUri(arg0);
    }

    @Override
    public String getAttributeQName(Object arg0) {
        return parent.getAttributeQName(arg0);
    }

    @Override
    public String getAttributeStringValue(Object arg0) {
        return parent.getAttributeStringValue(arg0);
    }

    @Override
    public Iterator getChildAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getChildAxisIterator(arg0);
    }

    @Override
    public String getCommentStringValue(Object arg0) {
        return parent.getCommentStringValue(arg0);
    }

    @Override
    public Iterator getDescendantAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getDescendantAxisIterator(arg0);
    }

    @Override
    public Iterator getDescendantOrSelfAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getDescendantOrSelfAxisIterator(arg0);
    }

    @Override
    public Object getDocument(String arg0) throws FunctionCallException {
        return parent.getDocument(arg0);
    }

    @Override
    public Object getDocumentNode(Object arg0) {
        return parent.getDocumentNode(arg0);
    }

    @Override
    public Object getElementById(Object arg0, String arg1) {
        return parent.getElementById(arg0, arg1);
    }

    @Override
    public String getElementName(Object arg0) {
        return parent.getElementName(arg0);
    }

    @Override
    public String getElementNamespaceUri(Object arg0) {
        return parent.getElementNamespaceUri(arg0);
    }

    @Override
    public String getElementQName(Object arg0) {
        return parent.getElementQName(arg0);
    }

    @Override
    public String getElementStringValue(Object arg0) {
        return parent.getElementStringValue(arg0);
    }

    @Override
    public Iterator getFollowingAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getFollowingAxisIterator(arg0);
    }

    @Override
    public Iterator getFollowingSiblingAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getFollowingSiblingAxisIterator(arg0);
    }

    @Override
    public Iterator getNamespaceAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getNamespaceAxisIterator(arg0);
    }

    @Override
    public String getNamespacePrefix(Object arg0) {
        return parent.getNamespacePrefix(arg0);
    }

    @Override
    public String getNamespaceStringValue(Object arg0) {
        return parent.getNamespaceStringValue(arg0);
    }

    @Override
    public short getNodeType(Object arg0) {
        return parent.getNodeType(arg0);
    }

    @Override
    public Iterator getParentAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getParentAxisIterator(arg0);
    }

    @Override
    public Object getParentNode(Object arg0) throws UnsupportedAxisException {
        return parent.getParentNode(arg0);
    }

    @Override
    public Iterator getPrecedingAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getPrecedingAxisIterator(arg0);
    }

    @Override
    public Iterator getPrecedingSiblingAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getPrecedingSiblingAxisIterator(arg0);
    }

    @Override
    public String getProcessingInstructionData(Object arg0) {
        return parent.getProcessingInstructionData(arg0);
    }

    @Override
    public String getProcessingInstructionTarget(Object arg0) {
        return parent.getProcessingInstructionTarget(arg0);
    }

    @Override
    public Iterator getSelfAxisIterator(Object arg0) throws UnsupportedAxisException {
        return parent.getSelfAxisIterator(arg0);
    }

    @Override
    public String getTextStringValue(Object arg0) {
        return parent.getTextStringValue(arg0);
    }

    @Override
    public boolean isAttribute(Object arg0) {
        return parent.isAttribute(arg0);
    }

    @Override
    public boolean isComment(Object arg0) {
        return parent.isComment(arg0);
    }

    @Override
    public boolean isDocument(Object arg0) {
        return parent.isDocument(arg0);
    }

    @Override
    public boolean isElement(Object arg0) {
        return parent.isElement(arg0);
    }

    @Override
    public boolean isNamespace(Object arg0) {
        return parent.isNamespace(arg0);
    }

    @Override
    public boolean isProcessingInstruction(Object arg0) {
        return parent.isProcessingInstruction(arg0);
    }

    @Override
    public boolean isText(Object arg0) {
        return parent.isText(arg0);
    }

    @Override
    public XPath parseXPath(String arg0) throws SAXPathException {
        return parent.parseXPath(arg0);
    }

    @Override
    public String translateNamespacePrefixToUri(String arg0, Object arg1) {
        return parent.translateNamespacePrefixToUri(arg0, arg1);
    }

    public NavigatorWrapper(Navigator parent) {
        this.parent = parent;
    }
}

/*
 * Copyright 2002,2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.jelly.tags.jsl;

import org.apache.commons.jelly.JellyException;
import org.apache.commons.jelly.expression.Expression;
import org.apache.commons.jelly.expression.ExpressionFactory;
import org.apache.commons.jelly.impl.TagScript;
import org.apache.commons.jelly.tags.xml.ExprTag;
import org.apache.commons.jelly.tags.xml.XMLTagLibrary;
import org.apache.commons.jelly.expression.xpath.XPathExpression;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.DocumentHelper;
import org.dom4j.rule.Pattern;

/** Describes the Taglib. This class could be generated by XDoclet
  *
  * @author <a href="mailto:jstrachan@apache.org">James Strachan</a>
  * @version $Revision: 155420 $
  */
public class JSLTagLibrary extends XMLTagLibrary {

    /** The Log to which logging calls will be made. */
    private Log log = LogFactory.getLog(JSLTagLibrary.class);

    public JSLTagLibrary() {
        registerTag("stylesheet", StylesheetTag.class);
        registerTag("style", StyleTag.class);
        registerTag("template", TemplateTag.class);
        registerTag("applyTemplates", ApplyTemplatesTag.class);
        registerTag("valueOf", ExprTag.class);
    }

    public Expression createExpression(
        ExpressionFactory factory,
        TagScript tagScript,
        String attributeName,
        String attributeValue) throws JellyException {

        // #### may need to include some namespace URI information in the XPath instance?

        if (attributeName.equals("select")) {
            if ( log.isDebugEnabled() ) {
                log.debug( "Parsing XPath expression: " + attributeValue );
            }

            Expression xpathExpr = createXPathTextExpression( attributeValue );

            return new XPathExpression(attributeValue, xpathExpr, tagScript);
        }

        if (attributeName.equals("match")) {
            if ( log.isDebugEnabled() ) {
                log.debug( "Parsing XPath pattern: " + attributeValue );
            }

            try {
                Pattern pattern = DocumentHelper.createPattern( attributeValue );
                return new XPathPatternExpression(attributeValue, pattern);
            }
            catch (Exception e) {
                throw new JellyException( "Could not parse XPath expression: \"" + attributeValue + "\" reason: " + e, e );
            }
        }

        // will use the default expression instead
        return super.createExpression(factory, tagScript, attributeName, attributeValue);
    }


}

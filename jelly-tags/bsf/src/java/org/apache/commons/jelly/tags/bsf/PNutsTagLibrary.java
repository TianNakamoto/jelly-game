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
package org.apache.commons.jelly.tags.bsf;

import org.apache.bsf.BSFManager;

/** Describes the Taglib. This class could be generated by XDoclet
  *
  * @author <a href="mailto:jstrachan@apache.org">James Strachan</a>
  * @version $Revision: 155420 $
  */
public class PNutsTagLibrary extends BSFTagLibrary {

    public PNutsTagLibrary() {
        BSFManager.registerScriptingEngine(
            "pnuts",
            "pnuts.ext.PnutsBSFEngine",
            new String[]{"pnut"}
        );
        setLanguage( "pnuts" );
    }

}

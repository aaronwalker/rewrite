/*
 * Copyright 2011 <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ocpsoft.rewrite.transform.cache;

import java.io.Serializable;

import org.ocpsoft.rewrite.event.Rewrite;
import org.ocpsoft.rewrite.servlet.http.event.HttpInboundServletRewrite;

public class RequestPathCacheKeyStrategy implements CacheKeyStrategy
{

   @Override
   public Serializable create(Rewrite event)
   {
      if (event instanceof HttpInboundServletRewrite) {
         return ((HttpInboundServletRewrite) event).getRequestPath();
      }
      throw new IllegalArgumentException("Event to supported: " + event.getClass().getName());
   }

}

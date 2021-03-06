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
package org.ocpsoft.rewrite.config;

import org.ocpsoft.rewrite.context.EvaluationContext;
import org.ocpsoft.rewrite.event.Rewrite;

/**
 * Encapsulates correlated {@link Condition} and {@link Operation} instances.
 * 
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 */
public interface Rule extends ConfigurationElement
{
   /**
    * Get the ID for this {@link Rule}
    */
   public String getId();

   /**
    * Evaluate this {@link Rule} and return true if all configured {@link Condition} objects are satisfied.
    */
   public boolean evaluate(Rewrite event, EvaluationContext context);

   /**
    * Perform all configured {@link Operation} objects specified by this {@link Rule}.
    */
   public void perform(Rewrite event, EvaluationContext context);
}

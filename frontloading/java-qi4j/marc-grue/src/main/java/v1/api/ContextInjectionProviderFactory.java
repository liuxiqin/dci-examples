/*
 * Copyright (c) 2010, Rickard Öberg. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package v1.api;

import org.qi4j.bootstrap.InvalidInjectionException;
import org.qi4j.runtime.injection.DependencyModel;
import org.qi4j.runtime.injection.InjectionContext;
import org.qi4j.runtime.injection.InjectionProvider;
import org.qi4j.runtime.injection.InjectionProviderFactory;
import org.qi4j.runtime.injection.provider.InjectionProviderException;
import org.qi4j.runtime.model.Resolution;

/**
 * Allow injection of @Context in roles
 */
public class ContextInjectionProviderFactory
      implements InjectionProviderFactory
{
   public InjectionProvider newInjectionProvider( Resolution resolution, DependencyModel dependencyModel ) throws InvalidInjectionException
   {
      return new ContextInjectionProvider( dependencyModel.rawInjectionType() );
   }

   static class ContextInjectionProvider
         implements InjectionProvider
   {
      private Class<?> contextType;

      public ContextInjectionProvider( Class<?> contextType )
      {
         this.contextType = contextType;
      }

      public Object provideInjection( InjectionContext context ) throws InjectionProviderException
      {
         try
         {
            return Contexts.context( contextType );
         }
         catch (IllegalArgumentException e)
         {
            throw new InjectionProviderException( "Could not find context of given type:" + contextType.getName(), e );
         }
      }
   }
}
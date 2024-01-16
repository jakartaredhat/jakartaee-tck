/*
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.cdi.tck.tests.lookup.modules.specialization.alternative;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Produces;

@Dependent
public class Factory {

    public static boolean eventDelivered;

    @Produces
    public Product produce() {
        return new Product();
    }

    public void observe(@Observes FactoryEvent event) {
        if (this.getClass().equals(Factory.class)) {
            eventDelivered = true;
        }
    }

    public static boolean isEventDelivered() {
        return eventDelivered;
    }

    public static void reset() {
        Factory.eventDelivered = false;
    }
}

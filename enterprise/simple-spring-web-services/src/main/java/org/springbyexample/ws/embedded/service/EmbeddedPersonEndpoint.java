/*
 * Copyright 2007-2012 the original author or authors.
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

package org.springbyexample.ws.embedded.service;

import org.springbyexample.person.schema.beans.GetPersonsRequest;
import org.springbyexample.person.schema.beans.Person;
import org.springbyexample.person.schema.beans.PersonResponse;
import org.springbyexample.ws.service.MarshallingPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

/**
 * Person service endpoint.
 * 
 * @author David Winterfeldt
 */
@Endpoint
public class EmbeddedPersonEndpoint implements MarshallingPersonService {
    
    private final Person person;
    
    /**
     * Constructor
     */
    @Autowired
    public EmbeddedPersonEndpoint(Person person) {
        this.person = person;
    }
    
    /**
     * Gets person list.
     */
    @PayloadRoot(localPart=GET_PERSONS_REQUEST, namespace=NAMESPACE)
    public PersonResponse getPersons(GetPersonsRequest request) {
        return new PersonResponse().withPerson(
                   person,
                   new Person().withId(2).withFirstName("John").withLastName("Jackson"));        
    }

}

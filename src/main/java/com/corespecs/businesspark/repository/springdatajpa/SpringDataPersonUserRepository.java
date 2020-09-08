/*
 * Copyright 2002-2013 the original author or authors.
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
package com.corespecs.businesspark.repository.springdatajpa;

import com.corespecs.businesspark.repository.PersonUserRepository;
import com.corespecs.businesspark.model.PersonUser;
import org.springframework.data.repository.Repository;

/**
 * Spring Data JPA specialization of the {@link PersonUserRepository} interface
 *
 * @author Abolaji salau
 */

//@Profile("spring-data-jpa")
public interface SpringDataPersonUserRepository extends PersonUserRepository, Repository<PersonUser, Integer> {

    /*@Override
    @Query("SELECT DISTINCT owner FROM PersonUser owner left join fetch owner.pets WHERE owner.lastName LIKE :lastName%")
    Collection<PersonUser> findByLastName(@Param("lastName") String lastName);

    @Override
    @Query("SELECT owner FROM PersonUser personUser left join fetch owner.pets WHERE owner.id =:id")
    PersonUser findById(@Param("id") int id);*/
}

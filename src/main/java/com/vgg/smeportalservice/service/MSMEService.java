/*
 * Copyright 2002-2017 the original author or authors.
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
package com.vgg.smeportalservice.service;

import com.vgg.smeportalservice.model.*;
import org.springframework.dao.DataAccessException;

import java.util.Collection;


/**
 * Mostly used as a facade so all controllers have a single point of entry
 *
 * @author Abolaji Salau
 *
 */
public interface MSMEService {

    PersonUser findOwnerById(int id) throws DataAccessException;

    Collection<PersonUser> findAllOwners() throws DataAccessException;

    void saveOwner(PersonUser owner) throws DataAccessException;

    //void deleteOwner(PersonUser owner) throws DataAccessException;

    Collection<PersonUser> findOwnerByLastName(String lastName) throws DataAccessException;

    Specialty findSpecialtyById(int specialtyId);

    Collection<Specialty> findAllSpecialties() throws DataAccessException;

    void saveSpecialty(Specialty specialty) throws DataAccessException;

    void deleteSpecialty(Specialty specialty) throws DataAccessException;

}

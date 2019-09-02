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

import com.vgg.smeportalservice.model.PersonUser;
import com.vgg.smeportalservice.model.Specialty;
import com.vgg.smeportalservice.repository.PersonUserRepository;
import com.vgg.smeportalservice.repository.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.ObjectRetrievalFailureException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @author Abolaji Salau
 *
 */
@Service
public class MSMEServiceImpl implements MSMEService {

    private PersonUserRepository ownerRepository;
    private SpecialtyRepository specialtyRepository;

    @Autowired
    public MSMEServiceImpl(PersonUserRepository ownerRepository, SpecialtyRepository specialtyRepository) {
        this.ownerRepository = ownerRepository;
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<PersonUser> findAllOwners() throws DataAccessException {
        return ownerRepository.findAll();
    }

   /* @Override
    @Transactional
    public void deleteOwner(PersonUser owner) throws DataAccessException {
        ownerRepository.delete(owner);
    }*/


    @Override
    @Transactional(readOnly = true)
    public Specialty findSpecialtyById(int specialtyId) {
        Specialty specialty = null;
        try {
            specialty = specialtyRepository.findById(specialtyId);
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return specialty;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<Specialty> findAllSpecialties() throws DataAccessException {
        return specialtyRepository.findAll();
    }

    @Override
    @Transactional
    public void saveSpecialty(Specialty specialty) throws DataAccessException {
        specialtyRepository.save(specialty);
    }

    @Override
    @Transactional
    public void deleteSpecialty(Specialty specialty) throws DataAccessException {
        specialtyRepository.delete(specialty);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonUser findOwnerById(int id) throws DataAccessException {
        PersonUser owner = null;
        try {
            owner = ownerRepository.findById(id);
        } catch (ObjectRetrievalFailureException | EmptyResultDataAccessException e) {
            // just ignore not found exceptions for Jdbc/Jpa realization
            return null;
        }
        return owner;
    }

        @Override
    @Transactional
    public void saveOwner(PersonUser owner) throws DataAccessException {
        ownerRepository.save(owner);

    }

    @Override
    @Transactional(readOnly = true)
    public Collection<PersonUser> findOwnerByLastName(String lastName) throws DataAccessException {
        return ownerRepository.findByLastName(lastName);
    }

}

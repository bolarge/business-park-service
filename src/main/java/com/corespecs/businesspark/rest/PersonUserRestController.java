/*
 * Copyright 2016-2017 the original author or authors.
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

package com.corespecs.businesspark.rest;

import com.corespecs.businesspark.service.MSMEService;
import com.corespecs.businesspark.model.PersonUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.Collection;

/**
 * @author Abolaji Salau
 */

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/owners")
public class PersonUserRestController {

    @Autowired
    private MSMEService clinicService;

    //@PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
    @RequestMapping(value = "/*/lastname/{lastName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<PersonUser>> getOwnersList(@PathVariable("lastName") String ownerLastName) {
        if (ownerLastName == null) {
            ownerLastName = "";
        }
        Collection<PersonUser> owners = this.clinicService.findOwnerByLastName(ownerLastName);
        if (owners.isEmpty()) {
            return new ResponseEntity<Collection<PersonUser>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<PersonUser>>(owners, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<PersonUser>> getOwners() {
        Collection<PersonUser> owners = this.clinicService.findAllOwners();
        if (owners.isEmpty()) {
            return new ResponseEntity<Collection<PersonUser>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Collection<PersonUser>>(owners, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
    @RequestMapping(value = "/{ownerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PersonUser> getOwner(@PathVariable("ownerId") int ownerId) {
        PersonUser owner = null;
        owner = this.clinicService.findOwnerById(ownerId);
        if (owner == null) {
            return new ResponseEntity<PersonUser>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PersonUser>(owner, HttpStatus.OK);
    }

    //@PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PersonUser> addOwner(@RequestBody @Valid PersonUser owner, BindingResult bindingResult,
                                          UriComponentsBuilder ucBuilder) {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (owner == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<PersonUser>(headers, HttpStatus.BAD_REQUEST);
        }
        this.clinicService.saveOwner(owner);
        headers.setLocation(ucBuilder.path("/api/owners/{id}").buildAndExpand(owner.getId()).toUri());
        return new ResponseEntity<PersonUser>(owner, headers, HttpStatus.CREATED);
    }

    //@PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
    @RequestMapping(value = "/{ownerId}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<PersonUser> updateOwner(@PathVariable("ownerId") int ownerId, @RequestBody @Valid PersonUser owner,
                                             BindingResult bindingResult, UriComponentsBuilder ucBuilder) {
        BindingErrorsResponse errors = new BindingErrorsResponse();
        HttpHeaders headers = new HttpHeaders();
        if (bindingResult.hasErrors() || (owner == null)) {
            errors.addAllErrors(bindingResult);
            headers.add("errors", errors.toJSON());
            return new ResponseEntity<PersonUser>(headers, HttpStatus.BAD_REQUEST);
        }
        PersonUser currentOwner = this.clinicService.findOwnerById(ownerId);
        if (currentOwner == null) {
            return new ResponseEntity<PersonUser>(HttpStatus.NOT_FOUND);
        }
        currentOwner.setAddress(owner.getAddress());
        currentOwner.setCity(owner.getCity());
        currentOwner.setFirstName(owner.getFirstName());
        currentOwner.setLastName(owner.getLastName());
        currentOwner.setTelephone(owner.getTelephone());
        this.clinicService.saveOwner(currentOwner);
        return new ResponseEntity<PersonUser>(currentOwner, HttpStatus.NO_CONTENT);
    }

   /* @PreAuthorize("hasRole(@roles.OWNER_ADMIN)")
    @RequestMapping(value = "/{ownerId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Transactional
    public ResponseEntity<Void> deleteOwner(@PathVariable("ownerId") int ownerId) {
        PersonUser owner = this.msmeTestService.findOwnerById(ownerId);
        if (owner == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        this.msmeTestService.deleteOwner(owner);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }*/

}

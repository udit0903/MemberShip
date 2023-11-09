package com.pinaka.MemberShip.controller;


import com.pinaka.MemberShip.collection.Owner;
import com.pinaka.MemberShip.collection.Person;
import com.pinaka.MemberShip.dto.request.*;
import com.pinaka.MemberShip.dto.response.OwnerDetailResponse;
import com.pinaka.MemberShip.dto.response.PersonResponse;
import com.pinaka.MemberShip.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static com.pinaka.MemberShip.utils.Constants.*;

@RestController
@EnableWebMvc
//@CrossOrigin(origins = "https://pinaka.netlify.app")
public class PersonController {

    @Autowired private PersonService personService;


    @GetMapping(value= ALL_PERSON_GET_URL ,produces =API_TYPE_RESPONSE)
    public ResponseEntity<List<PersonResponse>> getAllPerson() {


        String firstName="Udit";
        List<PersonResponse> personResponseList=  personService.getAllPerson(firstName);

       return new ResponseEntity<>(personResponseList, HttpStatus.OK);


    }

    @GetMapping(value= OWNER_DETAILS_GET_URL ,produces =API_TYPE_RESPONSE)
    public ResponseEntity<OwnerDetailResponse> getOwnerDetails(@RequestParam(value="_id",required =true) Long ownerId) {

      //  Long ownerId=16677L;

        return new ResponseEntity<>(personService.getOwnerDetails(ownerId), HttpStatus.OK);


    }


    @PutMapping (value= ADD_PERSON_PUT_URL ,consumes = {API_TYPE_RESPONSE2},produces = {API_TYPE_RESPONSE})
    public void addPerson(@ModelAttribute  PersonDetail personDetails) {
        Long ownerId=16677L;
        personService.addPersonDetails(personDetails,ownerId);
    }

    @GetMapping(value= PERSON_BY_ID_GET_URL ,produces =API_TYPE_RESPONSE)
    public ResponseEntity<PersonResponse> getByPersonId( @RequestParam(value="personId",required =true) String personId) {
        //String personId="P1889889898";
       Long ownerId=16677L;
        return new ResponseEntity<>( personService.getByPersonId(ownerId,personId), HttpStatus.OK);

    }


    @PutMapping(value= UPDATE_FEE_BY_PERSSON_ID_PUT_URL ,consumes = {API_TYPE_RESPONSE},produces = {API_TYPE_RESPONSE})
    public void updateFeeByPersonId(@RequestParam(value="_id",required =true) Long ownerId,@RequestParam(value="personId",required =true) String personId,@RequestBody FeeRequest feeRequest) {
         personService.updateFeeByPersonId(ownerId,personId,feeRequest);
    }
    @PutMapping(value= UPDATE_PROFILE_BY_PERSSON_ID_PUT_URL ,consumes = {API_TYPE_RESPONSE},produces = {API_TYPE_RESPONSE})
    public void updateProfileByPersonId(@RequestParam(value="_id",required =true) Long ownerId,@RequestParam(value="personId",required =true) String personId,@RequestBody PersonProfileRequest personProfileRequest) {
        personService.updateProfileByPersonId(ownerId,personId,personProfileRequest);
    }

    @PutMapping(value= UPDATE_FEE_BY_OWNER_ID_PUT_URL ,consumes = {API_TYPE_RESPONSE},produces = {API_TYPE_RESPONSE})
    public void updateFeeByOwnerId(@RequestParam(value="_id",required =true) Long ownerId,@RequestBody OwnerFeeRequest ownerFeeRequest) {
        personService.updateFeeByOwnerId(ownerId,ownerFeeRequest);
    }
    @PutMapping(value= UPDATE_PROFILE_BY_OWNER_ID_PUT_URL ,consumes = {API_TYPE_RESPONSE},produces = {API_TYPE_RESPONSE})
    public void updateProfileByOwnerId(@RequestParam(value="_id",required =true) Long ownerId,@RequestBody OwnerProfileRequest ownerProfileRequest) {
        personService.updateProfileByOwnerId(ownerId,ownerProfileRequest);
    }

    @PostMapping(value= FILTER_BY_MOBILE_AND_NAME_POST_URL ,consumes = {API_TYPE_RESPONSE},produces = {API_TYPE_RESPONSE})
    public List<PersonResponse> filterByMobileAndName(@RequestParam(value="_id",required =true) Long ownerId,@RequestBody FilterByMobileAndName filterByMobileAndName) {
       return personService.filterByMobileAndName(ownerId,filterByMobileAndName);
    }

    @GetMapping(value= FEE_PENDING_GET_URL ,produces = {API_TYPE_RESPONSE})
    public List<PersonResponse> getFeePending(@RequestParam(value="_id",required =true) Long ownerId) {
        return personService.getFeePending(ownerId);
    }


}

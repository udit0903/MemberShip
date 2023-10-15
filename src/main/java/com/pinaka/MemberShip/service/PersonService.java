package com.pinaka.MemberShip.service;

import com.pinaka.MemberShip.collection.MembershipDetail;
import com.pinaka.MemberShip.collection.Owner;
import com.pinaka.MemberShip.collection.Person;
import com.pinaka.MemberShip.dto.request.*;
import com.pinaka.MemberShip.dto.response.OwnerDetailResponse;
import com.pinaka.MemberShip.dto.response.PersonResponse;
import com.pinaka.MemberShip.helper.PersonServiceHelper;

import com.pinaka.MemberShip.repository.PersonRepository;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.pinaka.MemberShip.utils.Constants.DATE_PATTERN;

@Service

public class PersonService {


    @Autowired
     private PersonRepository personRepository;

    public List<Owner> getAllPerson(String firstName){
        List<Owner> personDetail =new ArrayList<>();

        personDetail=personRepository.getAllPerson( firstName);
        return personDetail;
    }

    public OwnerDetailResponse getOwnerDetails(Long ownerId){


        OwnerDetailResponse ownerDetailResponse=personRepository.findByOwnerId( ownerId);
        return ownerDetailResponse;
    }

    public void  addPersonDetails( PersonDetail personDetails,Long id){


        Person person =new Person();
        MembershipDetail membershipDetail= new MembershipDetail();

        person.setPersonId(personDetails.getPersonId());
        person.setAge(personDetails.getAge());
        person.setContactNo(personDetails.getContactNo());
        person.setGender(personDetails.getGender());
        membershipDetail.setDiscount(personDetails.getDiscount());
        membershipDetail.setStartDate(personDetails.getStartDate());
        membershipDetail.setEndDate(personDetails.getEndDate());
        membershipDetail.setMembership(personDetails.getMembership());
        membershipDetail.setTotal(personDetails.getTotal());
        person.setMembershipDetail(membershipDetail);
        person.setFirstName(personDetails.getFirstName());
        person.setLastName(personDetails.getLastName());


        personRepository.addPersonToDB(person,id);
    }

   public PersonResponse getByPersonId(Long ownerId,String personId){

        return personRepository.findByPeronId(ownerId,personId);
   }
    public void updateFeeByPersonId(Long ownerId, String personId, FeeRequest feeRequest){

        personRepository.updateFeeByPersonId(ownerId,personId,feeRequest);
    }

    public  void  updateProfileByPersonId(Long ownerId, String personId, PersonProfileRequest personProfileRequest){

        personRepository.updateProfileByPersonId(ownerId,personId,personProfileRequest);

    }
    public  void  updateFeeByOwnerId(Long ownerId, OwnerFeeRequest ownerFeeRequest){

        personRepository.updateFeeByOwnerId(ownerId,ownerFeeRequest);

    }
    public  void  updateProfileByOwnerId(Long ownerId, OwnerProfileRequest ownerProfileRequest){

        personRepository.updateProfileByOwnerId(ownerId,ownerProfileRequest);

    }
    public  List<PersonResponse> filterByMobileAndName(Long ownerId,FilterByMobileAndName filterByMobileAndName){

       return personRepository.filterByMobileAndName(ownerId, filterByMobileAndName);


    }

    public List<PersonResponse>  getFeePending(Long ownerId){
       return personRepository.findFeePending( ownerId);
    }


}

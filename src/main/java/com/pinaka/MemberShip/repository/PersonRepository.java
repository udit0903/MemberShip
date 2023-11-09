package com.pinaka.MemberShip.repository;


import com.mongodb.client.gridfs.model.GridFSFile;
import com.pinaka.MemberShip.collection.Fee;
import com.pinaka.MemberShip.collection.MembershipDetail;
import com.pinaka.MemberShip.collection.Owner;
import com.pinaka.MemberShip.collection.Person;
import com.pinaka.MemberShip.dto.request.*;
import com.pinaka.MemberShip.dto.response.OwnerDetailResponse;
import com.pinaka.MemberShip.dto.response.PersonResponse;
import com.pinaka.MemberShip.service.PersonService;
import org.apache.commons.lang3.time.DateUtils;


import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.util.FileCopyUtils;

import static com.pinaka.MemberShip.utils.Constants.DATE_PATTERN;


@Repository
public  class PersonRepository  {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private GridFsTemplate gridFsTemplate;



    public OwnerDetailResponse findByOwnerId(Long ownerId){


        Query query = new Query(Criteria.where("_id").is(ownerId));
        query.fields().include("contactNo");
        query.fields().include("firstName");
        query.fields().include("lastName");
        query.fields().include("ownerEmail");
        query.fields().include("fee");

        List<Owner> ownerList= mongoTemplate.find(query,Owner.class,"owner");
        Owner owner=ownerList.get(0);


        OwnerDetailResponse ownerResponse=new OwnerDetailResponse();
        ownerResponse.setContactNo(owner.getContactNo());
        ownerResponse.setOwnerEmail(owner.getOwnerEmail());
        ownerResponse.setFirstName(owner.getFirstName());
        ownerResponse.setLastName(owner.getLastName());
        ownerResponse.setFee(owner.getFee());



        return ownerResponse;

    }



    public List<PersonResponse> getAllPerson(String name){

        Query query = new Query(Criteria.where("firstName").is(name));
        query.fields().include("person");
        List<Owner> ownerList= mongoTemplate.find(query,Owner.class,"owner");
        List<Person>  personList=ownerList.get(0).getPerson();
        List<PersonResponse>  personResponseList=new ArrayList<>();

        for (Person person: personList){

            PersonResponse personResponse=new PersonResponse();
            GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(  person.getObjectId())));

                if (file != null) {
                    try {
                        GridFsResource resource = gridFsTemplate.getResource(file);
                        InputStream   inputStream = resource.getInputStream();
                        personResponse.setImage( FileCopyUtils.copyToByteArray(inputStream));
                        inputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to retrieve image", e);
                    }
                }
                personResponse.setPersonId(person.getPersonId());
                personResponse.setFirstName(person.getFirstName());
            MembershipDetail membershipDetail= person.getMembershipDetail();
            personResponse.setPersonId(person.getPersonId());
            personResponse.setContactNo(person.getContactNo());

            personResponse.setLastName(person.getLastName());

            personResponse.setStartDate(membershipDetail.getStartDate());
            personResponse.setEndDate(membershipDetail.getEndDate());
            personResponse.setMembership(membershipDetail.getMembership());
            personResponse.setTotal(membershipDetail.getTotal());
                 //personResponse=getPersonDetails(person);
            personResponseList.add(personResponse);


        }

    return personResponseList;
    }

  public void addPersonToDB(Person person,Long id ){

      Owner owner = mongoTemplate.findById(id,Owner.class);

      List<Person> personList=owner.getPerson();
      personList.add(person);
     final Owner updated =mongoTemplate.save(owner);
    }

    public PersonResponse findByPeronId(Long ownerId,String personId){


        Query query = new Query(Criteria.where("_id").is(ownerId));
        query.fields().include("person");
        List<Owner> ownerList= mongoTemplate.find(query,Owner.class,"owner");
        List<Person>  personList=ownerList.get(0).getPerson();
        PersonResponse personResponse=new PersonResponse();




        for (Person person: personList){
            if(person.getPersonId().equals(personId)){

                GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(  person.getObjectId())));

                if (file != null) {


                    try {
                        GridFsResource resource = gridFsTemplate.getResource(file);
                        InputStream   inputStream = resource.getInputStream();
                      personResponse.setImage( FileCopyUtils.copyToByteArray(inputStream));
                        inputStream.close();
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to retrieve image", e);
                    }
                }

                personResponse.setPersonId(person.getPersonId());
                personResponse.setFirstName(person.getFirstName());
                MembershipDetail membershipDetail= person.getMembershipDetail();
                personResponse.setPersonId(person.getPersonId());
                personResponse.setContactNo(person.getContactNo());

                personResponse.setLastName(person.getLastName());

                personResponse.setStartDate(membershipDetail.getStartDate());
                personResponse.setEndDate(membershipDetail.getEndDate());
                personResponse.setMembership(membershipDetail.getMembership());
                personResponse.setTotal(membershipDetail.getTotal());
            //  personResponse=getPersonDetails(person);
            }

        }



        return personResponse;

    }

    public void updateFeeByPersonId(Long ownerId, String personId, FeeRequest feeRequest){
        Owner owner = mongoTemplate.findById(ownerId,Owner.class);
        List<Person> personList=owner.getPerson();
        MembershipDetail membershipDetail= new MembershipDetail();

        for (Person person : personList){
            if(person.getPersonId().equals(personId)){
                membershipDetail.setDiscount(feeRequest.getDiscount());
                membershipDetail.setMembership(feeRequest.getMembership());
                membershipDetail.setTotal(feeRequest.getTotal());
                membershipDetail.setStartDate(feeRequest.getStartDate());
                membershipDetail.setEndDate(feeRequest.getEndDate());

                person.setMembershipDetail(membershipDetail);
            }
            final Owner updated =mongoTemplate.save(owner);
        }
    }


    public  void  updateProfileByPersonId(Long ownerId, String personId, PersonProfileRequest personProfileRequest){

        Owner owner = mongoTemplate.findById(ownerId,Owner.class);
        List<Person> personList=owner.getPerson();


        for (Person person : personList){
            if(person.getPersonId().equals(personId)){
                person.setPersonId(personProfileRequest.getPersonId());
                person.setAge(personProfileRequest.getAge());
                person.setGender(personProfileRequest.getGender());

                person.setContactNo(personProfileRequest.getContactNo());
                person.setFirstName(personProfileRequest.getFirstName());
                person.setLastName(personProfileRequest.getLastName());

            }
            final Owner updated =mongoTemplate.save(owner);
        }

    }

    public  void  updateFeeByOwnerId(Long ownerId, OwnerFeeRequest ownerFeeRequest){
        Owner owner = mongoTemplate.findById(ownerId,Owner.class);
        Fee fee=owner.getFee();
        fee.setOneMonth(ownerFeeRequest.getOneMonth());
        fee.setSixMonth(ownerFeeRequest.getSixMonth());
        fee.setThreeMonth(ownerFeeRequest.getThreeMonth());
        fee.setTwoMonth(ownerFeeRequest.getTwoMonth());
        owner.setFee(fee);
        final Owner updated =mongoTemplate.save(owner,"owner");
    }
    public  void  updateProfileByOwnerId(Long ownerId, OwnerProfileRequest ownerProfileRequest){

        Owner owner = mongoTemplate.findById(ownerId,Owner.class);
        owner.setOwnerId(ownerProfileRequest.getOwnerId());
        owner.setOwnerEmail(ownerProfileRequest.getOwnerEmail());
        owner.setFirstName(ownerProfileRequest.getFirstName());
        owner.setLastName(ownerProfileRequest.getLastName());
        owner.setPassword(ownerProfileRequest.getPassword());
        owner.setContactNo(ownerProfileRequest.getContactNo());
        final Owner updated =mongoTemplate.save(owner,"owner");



    }



    public  List<PersonResponse> filterByMobileAndName(Long ownerId,FilterByMobileAndName filterByMobileAndName){
        Query query = new Query(Criteria.where("_id").is(ownerId));
        query.fields().include("person");
        List<Owner> ownerList= mongoTemplate.find(query,Owner.class,"owner");
        List<Person>  personList=ownerList.get(0).getPerson();
        List<PersonResponse> personResponseList=new ArrayList<>();
        String firstName =filterByMobileAndName.getFirstName();
        for (Person person : personList){
            if(firstName!=null && !firstName.trim().isEmpty()){
                if(filterByMobileAndName.getContactNo().equals(person.getContactNo())&& firstName.equals(person.getFirstName()) ){
                    PersonResponse personResponse=  getPersonDetails(person);
                    personResponseList.add(personResponse);
                }
            }else{
                if(person.getContactNo().equals(filterByMobileAndName.getContactNo())){
                    PersonResponse personResponse=getPersonDetails(person);
                    personResponseList.add(personResponse);
                }
            }
          }
        return personResponseList;
    }



    public List<PersonResponse>  findFeePending(Long ownerId){

        Query query = new Query(Criteria.where("_id").is(ownerId));
        query.fields().include("person");
        List<Owner> ownerList= mongoTemplate.find(query,Owner.class,"owner");
        List<Person>  personList=ownerList.get(0).getPerson();
        List<PersonResponse> personResponseList=new ArrayList<>();
        for(Person person : personList){
            MembershipDetail membershipDetail=person.getMembershipDetail();
            Date endDate =getEndDate(membershipDetail.getEndDate());
            Date currentDate=new Date();
            if(currentDate.after(endDate)){
                PersonResponse personResponse=getPersonDetails(person);
                personResponseList.add(personResponse);
            }
        }
        return personResponseList;
    }
    public Date getEndDate(String endDate){

        Date date=new Date();
        try{
            date= DateUtils.parseDateStrictly(endDate,DATE_PATTERN);

        }catch (ParseException ex){
            ex.printStackTrace(); //properValidation
        }
        return date;

    }

    public PersonResponse getPersonDetails(Person person){

        PersonResponse personResponse=new PersonResponse();
        MembershipDetail membershipDetail= person.getMembershipDetail();
        personResponse.setPersonId(person.getPersonId());
        personResponse.setAge(person.getAge());
        personResponse.setGender(person.getGender());
        personResponse.setContactNo(person.getContactNo());
        personResponse.setFirstName(person.getFirstName());
        personResponse.setLastName(person.getLastName());
        personResponse.setDiscount(membershipDetail.getDiscount());
        personResponse.setStartDate(membershipDetail.getStartDate());
        personResponse.setEndDate(membershipDetail.getEndDate());
        personResponse.setMembership(membershipDetail.getMembership());
        personResponse.setTotal(membershipDetail.getTotal());
        return  personResponse;


    }




}


package com.pinaka.MemberShip.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Getter
@Setter


public class Person {


    @Field("personId")
    private String personId;
    @Field("contactNo")
    private String contactNo;
    @Field("firstName")
    private String firstName;
    @Field("lastName")
    private String lastName;
    @Field("age")
    private Integer age;
    @Field("gender")
    private String gender;
    @Field("membershipDetail")
    private MembershipDetail membershipDetail;





}

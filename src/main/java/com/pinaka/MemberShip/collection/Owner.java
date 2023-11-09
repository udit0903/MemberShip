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

@Document(collection = "owner")

public class Owner {
    @Id
    private  Long id;
    @Field("ownerId")
    private String ownerId;
    @Field("image")
    private Image image;
    @Field("contactNo")
    private String contactNo;
    @Field("firstName")
    private String firstName;
    @Field("lastName")
    private String lastName;

    @Field("password")
    private String password;

    @Field("ownerEmail")
    private String ownerEmail ;

    @Field("fee")
    private Fee fee;
    @Field("person")
    private List<Person> person;
}

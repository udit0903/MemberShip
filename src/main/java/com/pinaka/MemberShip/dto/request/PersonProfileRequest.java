package com.pinaka.MemberShip.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pinaka.MemberShip.collection.Image;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter

public class PersonProfileRequest {

    @JsonProperty("personId")
    private String personId;
    @Field("image")
    private Image image;
    @JsonProperty("contactNo")
    private String contactNo;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("gender")
    private String gender;
}

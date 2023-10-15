package com.pinaka.MemberShip.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PersonProfileRequest {

    @JsonProperty("personId")
    private String personId;
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

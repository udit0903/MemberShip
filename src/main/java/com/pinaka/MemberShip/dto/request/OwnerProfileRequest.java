package com.pinaka.MemberShip.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;
@Getter
@Setter
public class OwnerProfileRequest {

    @JsonProperty("ownerId")
    private String ownerId;
    @JsonProperty("contactNo")
    private String contactNo;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("password")
    private String password;
    @JsonProperty("ownerEmail")
    private String ownerEmail ;
}

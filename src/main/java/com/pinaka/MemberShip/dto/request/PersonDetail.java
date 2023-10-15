package com.pinaka.MemberShip.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter


public class PersonDetail {


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
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("membership")
    private String membership;
    @JsonProperty("discount")
    private Integer discount;
    @JsonProperty("total")
    private Integer total;


}

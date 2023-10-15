package com.pinaka.MemberShip.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterByMobileAndName {

    @JsonProperty("contactNo")
    private String contactNo;
    @JsonProperty("firstName")
    private String firstName;

}

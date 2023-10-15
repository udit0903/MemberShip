package com.pinaka.MemberShip.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonResponse {

    private String personId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String contactNo;
    private String gender;
    private String startDate;
    private String endDate;
    private String membership;
    private Integer discount;
    private Integer total;
}

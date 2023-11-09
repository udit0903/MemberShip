package com.pinaka.MemberShip.dto.response;

import com.pinaka.MemberShip.collection.Image;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class PersonResponse {

    private String personId;
    private String firstName;
    private byte[] image;
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

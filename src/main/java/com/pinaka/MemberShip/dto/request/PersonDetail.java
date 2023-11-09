package com.pinaka.MemberShip.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pinaka.MemberShip.collection.Image;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.web.multipart.MultipartFile;


@Getter
@Setter


public class PersonDetail {

    private String personId;

    private MultipartFile multipartFile;

    private String contactNo;

    private String firstName;

    private String lastName;

    private Integer age;

    private String gender;

    private String startDate;

    private String endDate;

    private String membership;

    private Integer discount;

    private Integer total;


}

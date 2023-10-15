package com.pinaka.MemberShip.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;
@Getter
@Setter
public class FeeResponse {

    private String startDate;
    private String endDate;
    private String membership;
    private Integer discount;
    private Integer total;
}

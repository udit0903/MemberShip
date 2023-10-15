package com.pinaka.MemberShip.collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter

public class MembershipDetail {

    @Field("startDate")
    private String startDate;
    @Field("endDate")
    private String endDate;
    @Field("membership")
    private String membership;
    @Field("discount")
    private Integer discount;
    @Field("total")
    private Integer total;
}

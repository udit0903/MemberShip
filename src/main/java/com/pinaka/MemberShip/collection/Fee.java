package com.pinaka.MemberShip.collection;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;


@Getter
@Setter
public class Fee {
    @Field("oneMonth")
    private Integer oneMonth;
    @Field("twoMonth")
    private Integer twoMonth;
    @Field("threeMonth")
    private Integer threeMonth;
    @Field("sixMonth")
    private Integer sixMonth;
}

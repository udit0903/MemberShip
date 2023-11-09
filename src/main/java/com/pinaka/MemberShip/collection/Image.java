package com.pinaka.MemberShip.collection;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
public class Image {
    @Field("name")
    private String name;
    @Field("data")
    private byte[] data;
}

package com.pinaka.MemberShip.dto.response;

import com.pinaka.MemberShip.collection.Fee;
import com.pinaka.MemberShip.collection.Image;
import com.pinaka.MemberShip.collection.Person;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter

public class OwnerDetailResponse {

    private String ownerId;

    private Image image;

    private String contactNo;

    private String firstName;

    private String lastName;

    private String password;

    private String ownerEmail ;

    private Fee fee;

}

package com.pinaka.MemberShip.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OwnerFeeRequest {

    @JsonProperty("oneMonth")
    private Integer oneMonth;
    @JsonProperty("twoMonth")
    private Integer twoMonth;
    @JsonProperty("threeMonth")
    private Integer threeMonth;
    @JsonProperty("sixMonth")
    private Integer sixMonth;
}

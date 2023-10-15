package com.pinaka.MemberShip.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeeRequest {
    @JsonProperty("startDate")
    private String startDate;
    @JsonProperty("endDate")
    private String endDate;
    @JsonProperty("membership")
    private String membership;
    @JsonProperty("discount")
    private Integer discount;
    @JsonProperty("total")
    private Integer total;
}

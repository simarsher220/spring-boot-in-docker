package org.codejudge.sb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuccessResponseDto {

    private String status;

    public SuccessResponseDto() {
        status = "success";
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }
}

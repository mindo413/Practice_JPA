package com.dhkim.practice_jpa.common.domain;

import com.dhkim.practice_jpa.common.constants.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "API 응답 모델")
public class APIResponseMsg {

    @ApiModelProperty(value = "리턴 코드")
    private Integer retVal;
    @ApiModelProperty(value = "리턴 메세지")
    private String retMsg;

    public APIResponseMsg(ErrorCode errorCode) {
        this.retVal = errorCode.getCode();
        this.retMsg = errorCode.getMsg();
    }
}

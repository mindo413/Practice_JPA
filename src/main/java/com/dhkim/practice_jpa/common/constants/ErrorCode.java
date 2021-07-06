package com.dhkim.practice_jpa.common.constants;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS(0000,"성공"),
    GET_MEMBER_ERR  (0001, "사용자 조회 실패"),
    ADD_MEMBER_ERR  (0002, "사용자 생성 실패"),
    MODIFY_MEMBER_ERR  (0003, "사용자 수정 실패"),
    REMOVE_MEMBER_ERR  (0004, "사용자 삭제 실패");

    private final int code;
    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

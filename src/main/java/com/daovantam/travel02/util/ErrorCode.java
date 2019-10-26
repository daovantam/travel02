package com.daovantam.travel02.util;

import java.util.Arrays;

public enum ErrorCode {
    NOT_BLANK(Code.NOT_BLANK, "object not blank");

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public interface Code {
        String NOT_BLANK = "001";
    }

    public String message() {
        return message;
    }

    //p.thuc values tra ve code cua ErrorCode
    public static String getMessage(String code) {
        return Arrays.stream(values()).filter(errorCode -> errorCode.code.equals(code)).
                findFirst()
                .get()
                .message();
    }
}

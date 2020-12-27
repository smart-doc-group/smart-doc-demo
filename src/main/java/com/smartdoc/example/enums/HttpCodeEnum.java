package com.smartdoc.example.enums;

/**
 * @author yu 2020/12/27.
 */
public enum  HttpCodeEnum {
    SUCCESS("200","ok"),
    BAD_REQUEST("400","Bad Request"),
    UNAUTHORIZED("401","Unauthorized"),
    FORBIDDEN("403","Forbidden"),
    NOT_FOUND("404","Not Found"),
    UNSUPPORTED_MEDIA_TYPE("415","Unsupported Media Type"),
    INTERNAL_SERVER_ERROR("500","Internal Server Error"),
    BAD_GATEWAY("502","Bad Gateway"),
    SERVICE_UNAVAILABLE("503","Service Unavailable");


    public String code;

    public String message;

    HttpCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }


    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

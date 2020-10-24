package com.lookcar.xsyz.ntfirst.enumresponse;

public enum ResponseEnum {

    SUCCESS("0","success"),
    PARAMS_NULL("1","params is null"),
    ACCOUNT_OR_PASSWORD_ERROR("2","用户名或密码错误")
    ;

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

package com.lookcar.xsyz.ntfirst.util;

import com.lookcar.xsyz.ntfirst.enumresponse.ResponseEnum;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> getSuccessResult() {
        return buildResponse(ResponseEnum.SUCCESS, null);
    }

    public static Map<String, Object> getSuccessResult(Object data) {
        return buildResponse(ResponseEnum.SUCCESS, data);
    }

    public static Map<String, Object> getResponseData(ResponseEnum responseEnum) {
        return buildResponse(responseEnum, null);
    }

    public static Map<String, Object> getResponseData(ResponseEnum responseEnum, Object data) {
        return buildResponse(responseEnum, data);
    }

    private static Map<String, Object> buildResponse(ResponseEnum responseEnum, Object data) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", responseEnum.getCode());
        result.put("msg", responseEnum.getMsg());
        if (data != null) {
            result.put("data", data);
        }
        return result;
    }
}

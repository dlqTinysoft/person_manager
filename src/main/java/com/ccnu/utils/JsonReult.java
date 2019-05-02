package com.ccnu.utils;

import com.ccnu.renum.ResultCode;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * created by 董乐强 on 2019/5/2
 */
public class JsonReult implements Serializable {

    private String code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;


    public JsonReult(String code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public JsonReult(String code,String message){
        this.code = code;
        this.message = message;
    }

    public JsonReult(ResultCode resultCode){
        this.code = resultCode.val();
        this.message = resultCode.msg();
    }
    public JsonReult(ResultCode resultCode,Object object){
        this.code = resultCode.val();
        this.message = resultCode.msg();
        this.data = object;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

package com.ccnu.renum;

/**
 * created by 董乐强 on 2019/5/2
 */
public enum ResultCode {
    /** 成功 */ SUCCESS("0000", "成功"),
    /** 登录失败 */ FAIL("4001", "操作失败"),
    UserNameExist("4004","用户名已经注册过"),
    RegisterFail("4004","用户名已经注册过");
    private ResultCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }
    public String val() {
        return val;
    }
    public String msg() {
        return msg;
    }
    private String val;
    private String msg;

}

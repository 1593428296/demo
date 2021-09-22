package com.example.demo;

import lombok.Data;

public enum Type1 {
    SUCCESS(1,"SUCCESS"),
    FAIL(2,"FAIL");

    private String desc;
    private Integer code;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    Type1(Integer code, String descr){
        this.code = code;
        this.desc = descr;
    }

    public static Type1 getType1ByCode(Integer code){
        if (code == null || code == 1){
            return SUCCESS;
        }else {
            return FAIL;
        }
    }

}

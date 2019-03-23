package com.yulece.updload.dto;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: ResultEnums
 * @Package com.yulece.updload.dto
 * @Description:
 * @Date 2019-03-22 20:53
 **/
public enum ResultEnums {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR")
    ;
    private Integer code;
    private String value;

    ResultEnums(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }}

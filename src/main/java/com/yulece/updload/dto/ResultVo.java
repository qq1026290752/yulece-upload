package com.yulece.updload.dto;

/**
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 *
 * @author wangyichao@28ph.cn
 * @Title: ResultVo
 * @Package com.yulece.updload.dto
 * @Description:
 * @Date 2019-03-22 20:48
 **/
public class ResultVo<T> {

    private Integer code;
    private  T data;
    private String message;

    public ResultVo(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public  static <T> ResultVo<T> createSuccessResultVo(String path){
        return new ResultVo(ResultEnums.SUCCESS.getCode(),null,path);
    }

    public  static <T> ResultVo<T> createErrorResultVo(String message){
        return new ResultVo(ResultEnums.ERROR.getCode(),null,message);
    }

}

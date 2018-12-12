package com.micro.hospital.bean;

import lombok.Data;

@Data
public class Result<T> {
    private String code;//错误码
    private String description;//提示信息
    private T result;//具体的内容

    public Result(String code,String description, T result){
        this.code = code;
        this.description = description;
        this.result = result;
    }
    public Result(){}
}

package com.micro.hospital.util;


import com.micro.hospital.bean.Result;

/**
 * 返回结果集
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode("0000");
        result.setDescription("成功");
        result.setResult(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(String info){
        Result result = new Result();
        result.setResult(null);
        result.setDescription(info);
        result.setCode("0002");
        return result;
    }
}

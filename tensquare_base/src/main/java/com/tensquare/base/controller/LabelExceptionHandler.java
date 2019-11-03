package com.tensquare.base.controller;

import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class LabelExceptionHandler {
    @ResponseBody
    @ExceptionHandler
    public Result error(Exception e){
       return new Result(false, StatusCode.ERROR,"基础服务异常"+ e.getMessage());
    }
}

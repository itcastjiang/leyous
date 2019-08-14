package com.leyou.common.advice;

import com.leyou.common.exception.LyException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class BasicExceptionAdvice {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String>handleException(RuntimeException e){
//        暂定异常返回状态码400，然后从异常中获取有好得提示信息
        return ResponseEntity.status(400).body(e.getMessage());
    }

    @ExceptionHandler(LyException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e){
        return  ResponseEntity.status(500).body(e.getMessage());
    }
}

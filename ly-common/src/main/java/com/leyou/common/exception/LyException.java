package com.leyou.common.exception;

import com.leyou.common.enums.ExceptionEnum;
import lombok.Getter;

@Getter
public class LyException extends RuntimeException {
    private int status;

    public LyException(ExceptionEnum exceptionEnum){
        super(exceptionEnum.getMessage());
         this.status=exceptionEnum.getStatus();
    }


    public LyException(ExceptionEnum exceptionEnum,Throwable throwable){
        super(exceptionEnum.getMessage(),throwable);
        this.status=exceptionEnum.getStatus();
    }
}

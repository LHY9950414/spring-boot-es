package example.es.common;

import example.es.enums.StatusCodeEnum;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private Integer code;//返回码
    private String message;//返回消息
    private T data;//返回数据

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = (T) data;
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Object data) {
        this();
        this.data = (T) data;
    }

    public Result() {
        this.code = StatusCodeEnum.OK.getCode();
        this.message = StatusCodeEnum.OK.getName();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

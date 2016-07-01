package com.jzc.util;

public class ResponseResult<T> {
    private int code;
    private String msg;
    private int total;
    private T data;
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public ResponseResult(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
    
    public ResponseResult(int code,String msg,int total,T data)
    {
        this.code=code;
        this.msg=msg;
        this.total=total;
        this.data=data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    
}

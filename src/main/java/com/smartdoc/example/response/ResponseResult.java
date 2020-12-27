package com.smartdoc.example.response;

import com.power.common.model.CommonResult;
import com.power.common.util.DateTimeUtil;

import java.io.Serializable;

/**
 * @author yu 2020/12/27.
 */
public class ResponseResult<T> implements Serializable {

    /**
     * serialVersionUID:.
     */
    private static final long serialVersionUID = -7268040542410707954L;


    /**
     * success
     *
     */
    private boolean success = false;

    /**
     * response status
     */
    private String status;

    /**
     * error msg
     */
    private String message;

    /**
     * response data
     */
    private T data;

    /**
     * response timestamp
     */
    private String timestamp;


    public ResponseResult() {

    }

    /**
     * @param success success
     * @param message the message
     */
    public ResponseResult(boolean success, String message) {
        this.setSuccess(success);
        this.setMessage(message);
    }

    /**
     * @param success success
     */
    public ResponseResult(boolean success) {
        this.setSuccess(success);
    }

    /**
     * @param status    error code
     * @param message the message
     */
    public ResponseResult(String status, String message) {
        this.setStatus(status);
        this.setMessage(message);
    }

    /**
     * Success response
     *
     * @return ResponseResult
     */
    public static ResponseResult ok() {
        return builder("200","succeed",true);
    }

    public ResponseResult<T> setResultData(T t){
        this.setData(t);
        return this;
    }


    /**
     * Failed response
     *
     * @param status the status
     * @param message  the message
     * @return ResponseResult
     */
    public static ResponseResult fail(String status, String message) {
        return builder(status, message, false);
    }

    private static <T> ResponseResult<T> builder(String status, String msg, boolean success) {
        ResponseResult result = new ResponseResult();
        result.setStatus(status);
        result.setSuccess(success);
        result.setMessage(msg);
        result.setTimestamp(DateTimeUtil.nowStrTime());
        return result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}

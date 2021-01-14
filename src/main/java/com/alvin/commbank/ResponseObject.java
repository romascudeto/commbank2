package com.alvin.commbank;

public class ResponseObject {

    private String status = "success";

    private Object data;

    private String error;

    public ResponseObject(Object data) {
        this.data = data;
    }
    public ResponseObject(String status, Object data, String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

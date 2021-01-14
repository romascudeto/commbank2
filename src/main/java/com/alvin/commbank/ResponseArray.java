package com.alvin.commbank;

import java.util.List;

public class ResponseArray {

    private String status = "success";

    private List data;

    private String error;

    public ResponseArray(List data)
    {
        this.data = data;
    }

    public ResponseArray(String status, List data, String error) {
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

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}

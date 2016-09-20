package com.sevenander.lifeslicetest.model;

import com.google.gson.annotations.SerializedName;

public class VideosResponse {
    @SerializedName("code")
    private String code;
    @SerializedName("data")
    private VideoData data;
    @SerializedName("success")
    private boolean success;
    @SerializedName("error")
    private String error;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public VideoData getData() {
        return data;
    }

    public void setData(VideoData data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

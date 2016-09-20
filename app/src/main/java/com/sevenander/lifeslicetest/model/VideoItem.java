package com.sevenander.lifeslicetest.model;

import com.google.gson.annotations.SerializedName;

public class VideoItem {

    @SerializedName("username")
    private String userName;
    @SerializedName("thumbnailUrl")
    private String userPhoto;
    @SerializedName("videoLowURL")
    private String videoSrc;

    private boolean nowPlaying;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getVideoSrc() {
        return videoSrc;
    }

    public void setVideoSrc(String videoSrc) {
        this.videoSrc = videoSrc;
    }

    public boolean isNowPlaying() {
        return nowPlaying;
    }

    public void setNowPlaying(boolean nowPlaying) {
        this.nowPlaying = nowPlaying;
    }
}

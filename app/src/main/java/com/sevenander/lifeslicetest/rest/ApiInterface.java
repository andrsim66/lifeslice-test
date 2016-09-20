package com.sevenander.lifeslicetest.rest;

import com.sevenander.lifeslicetest.model.VideosResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("timelines/tags/{tag}")
    Call<VideosResponse> getVideos(@Path("tag") String tag);
}

package com.sevenander.lifeslicetest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoData {
    @SerializedName("records")
    private List<VideoItem> items;
    @SerializedName("previousPage")
    private int previousPage;
    @SerializedName("nextPage")
    private int nextPage;
    @SerializedName("size")
    private int size;

    public List<VideoItem> getItems() {
        return items;
    }

    public void setItems(List<VideoItem> items) {
        this.items = items;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

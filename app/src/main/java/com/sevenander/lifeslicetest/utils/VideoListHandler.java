package com.sevenander.lifeslicetest.utils;

import com.sevenander.lifeslicetest.model.VideoItem;

import java.util.ArrayList;
import java.util.List;

public class VideoListHandler {

    private static VideoListHandler mInstance = null;

    private VideoListHandler() {
        items = new ArrayList<>();
    }

    public static VideoListHandler getInstance() {
        if (mInstance == null) {
            mInstance = new VideoListHandler();
        }
        return mInstance;
    }

    private List<VideoItem> items;

    public List<VideoItem> getItems() {
        return items;
    }

    public void addItem(VideoItem item) {
        if (item != null)
            items.add(item);
    }

    public void addAll(List<VideoItem> items) {
        if (this.items == null) {
            if (items != null)
                this.items = new ArrayList<>(items);
        } else {
            if (items != null)
                this.items.addAll(items);
        }
    }

    public void removeItem(int position) {
        if (position >= 0 && position < items.size())
            items.remove(position);
    }
}

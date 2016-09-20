package com.sevenander.lifeslicetest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sevenander.lifeslicetest.R;
import com.sevenander.lifeslicetest.adapters.holders.VideoItemViewHolder;
import com.sevenander.lifeslicetest.model.VideoItem;
import com.sevenander.lifeslicetest.utils.ImageUtils;
import com.sevenander.lifeslicetest.utils.callbacks.ListItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class VideoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<VideoItem> videoItems;
    private ListItemClickListener clickListener;
    private float thumbWidth;
    private int currentPlayingPosition;

    public VideoListAdapter(Context context, List<VideoItem> videoItems, ListItemClickListener clickListener) {
        this.context = context;
        this.videoItems = new ArrayList<>(videoItems);
        this.clickListener = clickListener;
        this.currentPlayingPosition = -1;
        this.thumbWidth = context.getResources().getDimension(R.dimen.size_72dp);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return initHolder(view);
    }

    private VideoItemViewHolder initHolder(View view) {
        return new VideoItemViewHolder(view, new VideoItemViewHolder.ViewHolderClicks() {
            @Override
            public void onItemClick(int position) {
                if (clickListener != null)
                    clickListener.onItemClick(position);
            }
        });
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VideoItemViewHolder userHolder = (VideoItemViewHolder) holder;

        VideoItem videoItem = videoItems.get(position);
        userHolder.tvUserName.setText(videoItem.getUserName());
        ImageUtils.setImage(videoItem.getUserPhoto(), userHolder.ivUserPicture, thumbWidth);

        if (videoItem.isNowPlaying()) {
            userHolder.tvUserName
                    .setTextColor(context.getResources().getColor(R.color.colorPrimary));
        } else {
            userHolder.tvUserName
                    .setTextColor(context.getResources().getColor(android.R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    public void highlightItem(int position) {
        if (currentPlayingPosition >= 0 && currentPlayingPosition < videoItems.size())
            videoItems.get(currentPlayingPosition).setNowPlaying(false);
        videoItems.get(position).setNowPlaying(true);
        notifyItemChanged(currentPlayingPosition);
        notifyItemChanged(position);
        currentPlayingPosition = position;
    }

//    public void addItem(MediaItem item) {
//        users.add(item);
//        notifyItemRangeChanged(0, users.size());
//    }
//
//    public void deleteItem(int position) {
//        users.remove(position);
//        notifyItemRemoved(position);
//        notifyItemRangeChanged(position, users.size());
//    }

//    public List<MediaItem> getMediaItems() {
//        return users;
//    }
}

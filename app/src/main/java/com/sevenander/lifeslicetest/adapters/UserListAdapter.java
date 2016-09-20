package com.sevenander.lifeslicetest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sevenander.lifeslicetest.R;
import com.sevenander.lifeslicetest.adapters.holders.UserViewHolder;
import com.sevenander.lifeslicetest.model.User;
import com.sevenander.lifeslicetest.utils.ImageUtils;
import com.sevenander.lifeslicetest.utils.callbacks.ListItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> users;
    private ListItemClickListener clickListener;
    private float thumbWidth;

    public UserListAdapter(Context context, List<User> users, ListItemClickListener clickListener) {
        this.users = new ArrayList<>(users);
        this.clickListener = clickListener;
        this.thumbWidth = context.getResources().getDimension(R.dimen.size_72dp);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return initHolder(view);
    }

    private UserViewHolder initHolder(View view) {
        return new UserViewHolder(view, new UserViewHolder.ViewHolderClicks() {
            @Override
            public void onItemClick(int position) {
                if (clickListener != null)
                    clickListener.onItemClick(users.get(position).getVideoSrc());
            }
        });
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        UserViewHolder userHolder = (UserViewHolder) holder;

        User user = users.get(position);
        userHolder.tvUserName.setText(user.getUserName());
        ImageUtils.setImage(user.getUserPhoto(), userHolder.ivUserPicture, thumbWidth);
    }

    @Override
    public int getItemCount() {
        return users.size();
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

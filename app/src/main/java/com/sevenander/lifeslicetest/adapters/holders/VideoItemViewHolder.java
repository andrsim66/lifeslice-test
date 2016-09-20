package com.sevenander.lifeslicetest.adapters.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sevenander.lifeslicetest.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class VideoItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @Bind(R.id.iv_user_picture)
    public ImageView ivUserPicture;
    @Bind(R.id.tv_user_name)
    public TextView tvUserName;

    protected ViewHolderClicks listener;

    public VideoItemViewHolder(View itemView, ViewHolderClicks listener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onItemClick(getAdapterPosition());
        }
    }

    public interface ViewHolderClicks {
        void onItemClick(int position);
    }
}

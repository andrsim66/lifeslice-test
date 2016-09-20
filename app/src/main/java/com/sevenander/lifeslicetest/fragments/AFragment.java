package com.sevenander.lifeslicetest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.sevenander.lifeslicetest.R;
import com.sevenander.lifeslicetest.model.VideoItem;
import com.sevenander.lifeslicetest.model.VideosResponse;
import com.sevenander.lifeslicetest.rest.ApiClient;
import com.sevenander.lifeslicetest.rest.ApiInterface;
import com.sevenander.lifeslicetest.utils.VideoListHandler;
import com.sevenander.lifeslicetest.utils.callbacks.FragmentCallback;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AFragment extends Fragment {

    @Bind(R.id.et_search_tag) EditText etSearchTag;

    private FragmentCallback mListener;

    public AFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        ButterKnife.bind(this, view);
        setupEditText();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentCallback) {
            mListener = (FragmentCallback) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentCallback");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.b_next)
    public void onNextClick() {
        String tag = etSearchTag.getText().toString();
        if (!TextUtils.isEmpty(tag)) {
            requestVideo(tag);
            hideKeyBoard();
        }
    }

    private void requestVideo(String tag) {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<VideosResponse> call = apiService.getVideos(tag);
        call.enqueue(new Callback<VideosResponse>() {
            @Override
            public void onResponse(Call<VideosResponse> call, Response<VideosResponse> response) {
                List<VideoItem> items = response.body().getData().getItems();
                Log.d("TAG1", "Number of videos received: " + items.size());
                VideoListHandler.getInstance().addAll(items);
                if (mListener != null)
                    mListener.onNextClick();
            }

            @Override
            public void onFailure(Call<VideosResponse> call, Throwable t) {
                Log.e("TAG1", t.toString());
            }
        });
    }

    private void setupEditText() {
        etSearchTag.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_NEXT) {
                    onNextClick();
                    handled = true;
                }
                return handled;
            }
        });
    }

    private void hideKeyBoard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

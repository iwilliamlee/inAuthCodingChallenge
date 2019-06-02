package com.application.myapplication.giphy_activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.application.myapplication.GlideApp;
import com.application.myapplication.R;
import com.application.myapplication.model.GiphyModel;

import java.util.List;

public class GiphyAdapter extends RecyclerView.Adapter<GiphyAdapter.GiphyViewHolder> {

    private List<GiphyModel> mGiphyList;
    private Context mContext;
    GiphyClickedListener mGiphyClickedListener;

    public GiphyAdapter(Context context, GiphyClickedListener giphyClickedListener) {
        mContext = context;
        mGiphyClickedListener = giphyClickedListener;
    }

    @NonNull
    @Override
    public GiphyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.giphy_list_item, parent, false);
        GiphyViewHolder vh = new GiphyViewHolder(v);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull GiphyAdapter.GiphyViewHolder holder, int position) {
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(mContext);
        circularProgressDrawable.setStrokeWidth(5f);
        circularProgressDrawable.setCenterRadius(30f);
        circularProgressDrawable.start();

        holder.mGiphyModel = mGiphyList.get(position);

        GlideApp.with(mContext)
                .load(mGiphyList.get(position).src)
                .placeholder(circularProgressDrawable)
                .centerCrop()
                .into(holder.mIvGiphy);

    }


    public class GiphyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public GiphyModel mGiphyModel;
        public ImageView mIvGiphy;
        public TextView mTvSortInfo;

        public GiphyViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            mIvGiphy = v.findViewById(R.id.iv_giphy);
        }

        @Override
        public void onClick(View view) {
            mGiphyClickedListener.onGiphyClicked(mGiphyModel);
        }
    }


    @Override
    public int getItemCount() {
        if(mGiphyList == null) return 0;
        return mGiphyList.size();
    }

    public void updateList(List<GiphyModel> models) {
        mGiphyList = models;
        notifyDataSetChanged();
    }

}

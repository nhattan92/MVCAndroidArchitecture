package com.myself.mvcandroid.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myself.mvcandroid.R;
import com.myself.mvcandroid.model.FakeData;

import java.util.List;

/**
 * Created by admin on 3/10/2019.
 */

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.MyViewHolder> {

    private List<FakeData> mFakeDataList;
    private IOnClickItemListener mIOnClickItemListener;

    public MyRvAdapter(List<FakeData> fakeDataList, IOnClickItemListener iOnClickItemListener) {
        this.mFakeDataList = fakeDataList;
        this.mIOnClickItemListener = iOnClickItemListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.mTitle.setText(mFakeDataList.get(position).getTitle());
        holder.mId.setText(String.valueOf(mFakeDataList.get(position).getId()));
        holder.mContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIOnClickItemListener.showToast(mFakeDataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFakeDataList.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mId;
        private View mContainer;

        public MyViewHolder(View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.tv_title);
            mId = itemView.findViewById(R.id.tv_id);
            mContainer = itemView.findViewById(R.id.item_container);
        }
    }

    public interface IOnClickItemListener {
        void showToast(FakeData fakeData);
    }
}


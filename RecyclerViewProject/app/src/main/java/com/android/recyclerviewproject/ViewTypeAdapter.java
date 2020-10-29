package com.android.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class ViewTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int ONE_ITEM = 1;
    public static final int TWO_ITEM = 2;
    public static final int THREE_ITEM = 3;
    private List<String> mDatas;

    public void setmDatas(List<String> mDatas) {
        this.mDatas = mDatas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        RecyclerView.ViewHolder holder = null;
        if (ONE_ITEM == viewType) {
            View v = mInflater.inflate(R.layout.item_linear, parent, false);
            holder = new OneViewHolder(v);
        } else if (THREE_ITEM == viewType) {
            View v = mInflater.inflate(R.layout.item_three, parent, false);
            holder = new TwoViewHolder(v);
        } else {
            View v = mInflater.inflate(R.layout.item_two, parent, false);
            holder = new TwoViewHolder(v);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OneViewHolder) {
            ((OneViewHolder) holder).tv.setText(mDatas.get(position));
        } else if (holder instanceof ThreeHolder) {

        } else {
            ((TwoViewHolder) holder).tv1.setText(mDatas.get(position));
            ((TwoViewHolder) holder).tv2.setText(mDatas.get(position));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return TWO_ITEM;
        } else if (position % 5 == 0) {
            return THREE_ITEM;

        } else {
            return ONE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class OneViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public OneViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.adapter_linear_text);
        }
    }

    class TwoViewHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2;

        public TwoViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.adapter_two_1);
            tv2 = (TextView) itemView.findViewById(R.id.adapter_two_2);
        }
    }

    class ThreeHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv2;

        public ThreeHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.adapter_two_1);
            tv2 = (TextView) itemView.findViewById(R.id.adapter_two_2);
        }
    }
}
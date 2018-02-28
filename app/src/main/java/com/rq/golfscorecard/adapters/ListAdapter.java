package com.rq.golfscorecard.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.rq.golfscorecard.R;
import com.rq.golfscorecard.model.Hole;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Faydee on 2018/2/28.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context context;
    private Hole[] holes;

    public ListAdapter(Context context, Hole[] holes) {
        this.context = context;
        this.holes = holes;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.holeTextView) TextView holeTextView;
        @BindView(R.id.strokeCountTextView) TextView strokeCountTextView;
        @BindView(R.id.removeStrokeButton) Button removeStrokeButton;
        @BindView(R.id.addStrokeButton) Button addStrokeButton;

        public ListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindHole(Hole hole) {
            holeTextView.setText(hole.getTitle());
            strokeCountTextView.setText(String.valueOf(hole.getStrokeCount()));
        }

        @OnClick(R.id.removeStrokeButton) void removeStrokeButtonPressed() {
            int updatedStrokeCount = holes[getAdapterPosition()].getStrokeCount() - 1;
            if (updatedStrokeCount < 0) updatedStrokeCount = 0;
            holes[getAdapterPosition()].setStrokeCount(updatedStrokeCount);
            strokeCountTextView.setText(String.valueOf(updatedStrokeCount));
        }

        @OnClick(R.id.addStrokeButton) void addStrokeButtonPressed() {
            int updatedStrokeCount = holes[getAdapterPosition()].getStrokeCount() + 1;
            holes[getAdapterPosition()].setStrokeCount(updatedStrokeCount);
            strokeCountTextView.setText(String.valueOf(updatedStrokeCount));
        }
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ListViewHolder holder = new ListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.bindHole(holes[position]);
    }

    @Override
    public int getItemCount() {
        return holes.length;
    }
}

package com.jadwal.pelajaran;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.util.Collections;
import java.util.List;
import android.graphics.drawable.*;


public class RecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<Data> list = Collections.emptyList();
    Context context;

    public RecycleViewAdapter(List<Data> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nomor.setText(list.get(position).nomor);
        holder.nomor.setTextColor(list.get(position).warnaText);
        holder.title.setText(list.get(position).title);
        holder.title.setTextColor(list.get(position).warnaText);
        holder.description.setText(list.get(position).description);
        holder.description.setTextColor(list.get(position).warnaText);
        holder.cv.setCardBackgroundColor(list.get(position).warna);
        //holder.imageView.setImageResource(list.get(position).imageId);

        //animate(holder);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView
    public void insert(int position, Data data) {
        list.add(position, data);
        notifyItemInserted(position);
    }
    // Remove a RecyclerView item containing the Data object
    public void remove(Data data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

    // public void animate(RecyclerView.ViewHolder viewHolder) {
    // final Animation animAnticipateOvershoot = AnimationUtils.loadAnimation(context, R.anim.anticipate_overshoot_interpolator);
    //  viewHolder.itemView.setAnimation(animAnticipateOvershoot);
    //  }

}

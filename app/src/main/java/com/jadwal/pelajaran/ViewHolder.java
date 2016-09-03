package com.jadwal.pelajaran;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


//The adapters View Holder
public class ViewHolder extends RecyclerView.ViewHolder {

    CardView cv;
    TextView nomor;
    TextView title;
    TextView description;
    ImageView imageView;

    ViewHolder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        nomor = (TextView)itemView.findViewById(R.id.nomor);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
        // imageView = (ImageView) itemView.findViewById(R.id.imageView);
    }

}

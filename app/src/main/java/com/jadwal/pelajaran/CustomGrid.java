package com.jadwal.pelajaran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGrid extends BaseAdapter{
    private Context mContext;
    private final String[] namaKelas;
     

    public CustomGrid(Context c,String[] namaKelas ) {
        mContext = c;
        
        this.namaKelas = namaKelas;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return namaKelas.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
            .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {  

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.main_grid, null);
            TextView textView = (TextView) grid.findViewById(R.id.nama_kelas);
            
            textView.setText(namaKelas[position]);
            
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}

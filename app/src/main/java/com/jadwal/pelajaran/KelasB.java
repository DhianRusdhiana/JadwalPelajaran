package com.jadwal.pelajaran;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.support.v7.app.*;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.*;

import butterknife.Bind;
import butterknife.ButterKnife;
import android.support.design.widget.*;
import com.dhian.*;
import android.support.v7.widget.*;
import java.util.*;

public class KelasB extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener 
{
    RecyclerView recyclerView;
    private RecycleViewAdapter rvadapter;
    private int currentPosition = 0;

    @Bind(R.id.appbar)
    AppBarLayout appBarLayout;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @Bind(R.id.anim_toolbar)
    Toolbar toolbar;

    @Bind(R.id.toolbar_header_view)
    HeaderView toolbarHeaderView;

    @Bind(R.id.float_header_view)
    HeaderView floatHeaderView;

    private boolean isHideToolbarView = false;


    private ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_kelas);

        ButterKnife.bind(this);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vp = (ViewPager) findViewById(R.id.pager);
        CustomPagerAdapter adapter = new CustomPagerAdapter(this);
        vp.setAdapter(adapter);
        //vp.setOnPageChangeListener(new MyPageChangeListener());
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");

        toolbarHeaderView = (HeaderView)findViewById(R.id.toolbar_header_view);
        floatHeaderView = (HeaderView)findViewById(R.id.float_header_view);
        appBarLayout = (AppBarLayout)findViewById(R.id.appbar);

        toolbarHeaderView.bindTo("Jadwal Pelajaran",16,"Kelas 9B",12,false);
        floatHeaderView.bindTo("Jadwal Pelajaran",30,"Kelas 9B",18,true);

        appBarLayout.addOnOffsetChangedListener(this);
        
        
        
        
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
        }
        return true;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {

        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        if (percentage == 1f && isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.VISIBLE);
            isHideToolbarView = !isHideToolbarView;

        } else if (percentage < 1f && !isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.GONE);
            isHideToolbarView = !isHideToolbarView;
        }
    }

    public class CustomPagerAdapter extends PagerAdapter {

        private Context mContext;

        public CustomPagerAdapter(Context context) {
            mContext = context;
        }

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
            LayoutInflater inflater = LayoutInflater.from(mContext);
            ViewGroup layout = (ViewGroup) inflater.inflate(customPagerEnum.getLayoutResId(), collection, false);
            collection.addView(layout);
            List<Data> data = senin();
            List<Data> data2 = selasa();
            List<Data> data3 = rabu();
            List<Data> data4 = kamis();
            List<Data> data5 = jumat();
            
            recyclerView = (RecyclerView)layout.findViewById(R.id.recyclerview);
            switch(position){
                case 0:
                    rvadapter = new RecycleViewAdapter(data, getApplication());
                    recyclerView.setAdapter(rvadapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(KelasB.this));
                    break;
                case 1:
                    rvadapter = new RecycleViewAdapter(data2, getApplication());
                    recyclerView.setAdapter(rvadapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(KelasB.this));
                    break;
                case 2:
                    rvadapter = new RecycleViewAdapter(data3, getApplication());
                    recyclerView.setAdapter(rvadapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(KelasB.this));
                    break;
                case 3:
                    rvadapter = new RecycleViewAdapter(data4, getApplication());
                    recyclerView.setAdapter(rvadapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(KelasB.this));
                    break;
                case 4:
                    rvadapter = new RecycleViewAdapter(data5, getApplication());
                    recyclerView.setAdapter(rvadapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(KelasB.this));
                    break;
            }
            
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return CustomPagerEnum.values().length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            CustomPagerEnum customPagerEnum = CustomPagerEnum.values()[position];
            return mContext.getString(customPagerEnum.getTitleResId());
        }

    }

    public enum CustomPagerEnum {

        SENIN(R.string.senin, R.layout.list_pelajaran),
        SELASA(R.string.selasa, R.layout.list_pelajaran),
        RABU(R.string.rabu, R.layout.list_pelajaran),
        KAMIS(R.string.kamis, R.layout.list_pelajaran),
        JUMAT(R.string.jumat,R.layout.list_pelajaran);

        private int mTitleResId;
        private int mLayoutResId;

        CustomPagerEnum(int titleResId, int layoutResId) {
            mTitleResId = titleResId;
            mLayoutResId = layoutResId;
        }

        public int getTitleResId() {
            return mTitleResId;
        }

        public int getLayoutResId() {
            return mLayoutResId;
        }

    }
    public List<Data> senin() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("1","07:00 - 07:40","Pelajaran 1,B",0xffffffff,0xff008080));
        data.add(new Data("2","07:40 - 08:20", "Pelajaran 2",0xffffffff,0xff008080));
        data.add(new Data("3","08:20 - 09:00","Pelajaran 3",0xffffffff,0xff008080));
        data.add(new Data("4","09:00 - 10:40", "Pelajaran 4",0xffffffff,0xff008080));
        data.add(new Data("5","09:40 - 10:00","Istirahat",0xff008080,0xffffffff));
        data.add(new Data("6","10:00 - 10:40", "Pelajaran 5",0xffffffff,0xff008080));
        data.add(new Data("7","10:40 - 11:20", "Pelajaran 6",0xffffffff,0xff008080));
        data.add(new Data("8","11:20 - 12:00","Pelajaran 7",0xffffffff,0xff008080));
        data.add(new Data("9","12:00 - 12:40", "Istirahat",0xff008080,0xffffffff));
        data.add(new Data("10","12:40 - 13:20", "Pelajaran 8",0xffffffff,0xff008080));
        data.add(new Data("11","13:20 - 14:00","Pelajaran 9",0xffffffff,0xff008080));
        data.add(new Data("12","14:00 - 14:40", "Pelajaran 10",0xffffffff,0xff008080));
        
        
        

        return data;
    }
    public List<Data> selasa() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("1","07:00 - 07:40","Pelajaran 1,B",0xffffffff,0xff008080));
        data.add(new Data("2","07:40 - 08:20", "Pelajaran 2",0xffffffff,0xff008080));
        data.add(new Data("3","08:20 - 09:00","Pelajaran 3",0xffffffff,0xff008080));
        data.add(new Data("4","09:00 - 10:40", "Pelajaran 4",0xffffffff,0xff008080));
        data.add(new Data("5","09:40 - 10:00","Istirahat",0xff008080,0xffffffff));
        data.add(new Data("6","10:00 - 10:40", "Pelajaran 5",0xffffffff,0xff008080));
        data.add(new Data("7","10:40 - 11:20", "Pelajaran 6",0xffffffff,0xff008080));
        data.add(new Data("8","11:20 - 12:00","Pelajaran 7",0xffffffff,0xff008080));
        data.add(new Data("9","12:00 - 12:40", "Istirahat",0xff008080,0xffffffff));
        data.add(new Data("10","12:40 - 13:20", "Pelajaran 8",0xffffffff,0xff008080));
        data.add(new Data("11","13:20 - 14:00","Pelajaran 9",0xffffffff,0xff008080));
        data.add(new Data("12","14:00 - 14:40", "Pelajaran 10",0xffffffff,0xff008080));
        

        return data;
    }
    public List<Data> rabu() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("1","07:00 - 07:40","Pelajaran 1",0xffffffff,0xff008080));
        data.add(new Data("2","07:40 - 08:20", "Pelajaran 2",0xffffffff,0xff008080));
        data.add(new Data("3","08:20 - 09:00","Pelajaran 3",0xffffffff,0xff008080));
        data.add(new Data("4","09:00 - 10:40", "Pelajaran 4",0xffffffff,0xff008080));
        data.add(new Data("5","09:40 - 10:00","Istirahat",0xff008080,0xffffffff));
        data.add(new Data("6","10:00 - 10:40", "Pelajaran 5",0xffffffff,0xff008080));
        data.add(new Data("7","10:40 - 11:20", "Pelajaran 6",0xffffffff,0xff008080));
        data.add(new Data("8","11:20 - 12:00","Pelajaran 7",0xffffffff,0xff008080));
        data.add(new Data("9","12:00 - 12:40", "Istirahat",0xff008080,0xffffffff));
        data.add(new Data("10","12:40 - 13:20", "Pelajaran 8",0xffffffff,0xff008080));
        data.add(new Data("11","13:20 - 14:00","Pelajaran 9",0xffffffff,0xff008080));
        data.add(new Data("12","14:00 - 14:40", "Pelajaran 10",0xffffffff,0xff008080));


        return data;
    }
    public List<Data> kamis() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("1","07:00 - 07:40","Pelajaran 1",0xffffffff,0xff008080));
        data.add(new Data("2","07:40 - 08:20", "Pelajaran 2",0xffffffff,0xff008080));
        data.add(new Data("3","08:20 - 09:00","Pelajaran 3",0xffffffff,0xff008080));
        data.add(new Data("4","09:00 - 10:40", "Pelajaran 4",0xffffffff,0xff008080));
        data.add(new Data("5","09:40 - 10:00","Istirahat",0xff008080,0xffffffff));
        data.add(new Data("6","10:00 - 10:40", "Pelajaran 5",0xffffffff,0xff008080));
        data.add(new Data("7","10:40 - 11:20", "Pelajaran 6",0xffffffff,0xff008080));
        data.add(new Data("8","11:20 - 12:00","Pelajaran 7",0xffffffff,0xff008080));
        data.add(new Data("9","12:00 - 12:40", "Istirahat",0xff008080,0xffffffff));
        data.add(new Data("10","12:40 - 13:20", "Pelajaran 8",0xffffffff,0xff008080));
        data.add(new Data("11","13:20 - 14:00","Pelajaran 9",0xffffffff,0xff008080));
        data.add(new Data("12","14:00 - 14:40", "Pelajaran 10",0xffffffff,0xff008080));


        return data;
    }
    
    public List<Data> jumat() {

        List<Data> data = new ArrayList<>();

        data.add(new Data("1","07:00 - 07:40","Pelajaran 1",0xffffffff,0xff008080));
        data.add(new Data("2","07:40 - 08:20", "Pelajaran 2",0xffffffff,0xff008080));
        data.add(new Data("3","08:20 - 09:00","Pelajaran 3",0xffffffff,0xff008080));
        data.add(new Data("4","09:00 - 10:40", "Pelajaran 4",0xffffffff,0xff008080));
        data.add(new Data("5","09:40 - 10:00","Istirahat",0xff008080,0xffffffff));
        data.add(new Data("6","10:00 - 10:40", "Pelajaran 5",0xffffffff,0xff008080));
        data.add(new Data("7","10:40 - 11:20", "Pelajaran 6",0xffffffff,0xff008080));
        data.add(new Data("8","11:20 - 12:30","Shalat Jum'at",0xff008080,0xffffffff));
        

        return data;
    }
    
    private class MyPageChangeListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            Toast.makeText(KelasB.this,String.valueOf(position),Toast.LENGTH_SHORT).show();
            currentPosition = position;
            switch(position){
                
                case 0:
                  //  List<Data> data = fill_with_data();
                 //   recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
                  //  rvadapter = new RecycleViewAdapter(data, getApplication());
                 //   recyclerView.setAdapter(rvadapter);
                  //  recyclerView.setLayoutManager(new LinearLayoutManager(KelasA.this));
                break;
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
            }
            
        }
    }

}

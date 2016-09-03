package com.jadwal.pelajaran;

import android.app.*;
import android.os.*;
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
import android.view.*;
import android.content.*;

public class MainActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener  
{
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
    
    GridView grid;
    String[] namaKelas = {"9A","9B","9C","9D","9E","9F","9G","9H","9I"};
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        ButterKnife.bind(this);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.anim_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");

        toolbarHeaderView = (HeaderView)findViewById(R.id.toolbar_header_view);
        floatHeaderView = (HeaderView)findViewById(R.id.float_header_view);
        appBarLayout = (AppBarLayout)findViewById(R.id.appbar);

        toolbarHeaderView.bindTo("Jadwal Pelajaran",16,"SMP xxx xxx",12,false);
        floatHeaderView.bindTo("Jadwal Pelajaran",30,"SMP xxx xxx",22,true);

        appBarLayout.addOnOffsetChangedListener(this);

        CustomGrid adapter = new CustomGrid(MainActivity.this, namaKelas);
        grid=(GridView)findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    switch(position){
                        case 0:
                            Intent i = new Intent(MainActivity.this,KelasA.class);
                            startActivity(i);
                            break;
                        case 1:
                            Intent i2 = new Intent(MainActivity.this,KelasB.class);
                            startActivity(i2);
                            break;
                        case 2:
                            Intent i3 = new Intent(MainActivity.this,KelasC.class);
                            startActivity(i3);
                            break;
                        case 3:
                            Intent i4 = new Intent(MainActivity.this,KelasD.class);
                            startActivity(i4);
                            break;
                        case 4:
                            Intent i5 = new Intent(MainActivity.this,KelasE.class);
                            startActivity(i5);
                            break;
                        case 5:
                            Intent i6 = new Intent(MainActivity.this,KelasF.class);
                            startActivity(i6);
                            break;
                        case 6:
                            Intent i7 = new Intent(MainActivity.this,KelasG.class);
                            startActivity(i7);
                            break;
                        case 7:
                            Intent i8 = new Intent(MainActivity.this,KelasH.class);
                            startActivity(i8);
                            break;
                        case 8:
                            Intent i9 = new Intent(MainActivity.this,KelasI.class);
                            startActivity(i9);
                            break;
                    }

                }
            });
            
            


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            case R.id.about:
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.getWindow();
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.about);
                dialog.setCancelable(false);
                
                TextView ok = (TextView)dialog.findViewById(R.id.ok);
                ok.setOnClickListener(new OnClickListener(){
                    public void onClick(View v){
                        dialog.dismiss();
                    }
                });

                // set the custom dialog components - text, image and button
                

                dialog.show();
                break;
            case R.id.exit:
                MainActivity.this.finish();
        }
        return true;
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {

        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        if (percentage == 1f && isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.VISIBLE);
            floatHeaderView.setVisibility(View.GONE);
            isHideToolbarView = !isHideToolbarView;

        } else if (percentage < 1f && !isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.GONE);
            floatHeaderView.setVisibility(View.VISIBLE);
            isHideToolbarView = !isHideToolbarView;
        }
    }
}

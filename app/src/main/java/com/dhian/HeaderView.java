package com.dhian;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.jadwal.pelajaran.R;
import android.graphics.*;

public class HeaderView extends LinearLayout{

    @Bind(R.id.header_view_title)
    TextView title;

    @Bind(R.id.header_view_sub_title)
    TextView subTitle;


    public HeaderView(Context context) {
        super(context);
    }

    public HeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        title = (TextView)findViewById(R.id.header_view_title);
        subTitle = (TextView)findViewById(R.id.header_view_sub_title);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public HeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        title = (TextView)findViewById(R.id.header_view_title);
        subTitle = (TextView)findViewById(R.id.header_view_sub_title);

    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void bindTo(String title) {

        bindTo(title,16,"",16,false);
    }

    public void bindTo(String title,float titleSize,String subTitle,float subtitleSize,boolean shadow) {
        this.title = (TextView)findViewById(R.id.header_view_title);
        this.subTitle = (TextView)findViewById(R.id.header_view_sub_title);
        this.title.setTextSize(titleSize);
        this.subTitle.setTextSize(subtitleSize);
        if(shadow == true){
            this.title.setShadowLayer(5,5,5,Color.BLACK);
            this.subTitle.setShadowLayer(5,5,5,Color.BLACK);
        }
        hideOrSetText(this.title, title);
        hideOrSetText(this.subTitle, subTitle);
    }

    private void hideOrSetText(TextView tv, String text) {
        if (text == null || text.equals(""))
            tv.setVisibility(GONE);
        else
            tv.setText(text);
    }




}

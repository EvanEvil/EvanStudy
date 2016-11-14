package com.huawei.develop.viewdraghelperdemo.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import com.hanks.htextview.HTextView;
import com.huawei.develop.viewdraghelperdemo.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class MyTextViewActivity extends AppCompatActivity {
    private TextView tv_maxMemory;
    private HTextView hTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_text_view);

        //ExpandableTextView
        ExpandableTextView expTv1 = (ExpandableTextView) findViewById(R.id.expand_text_view);
        expTv1.setText(getString(R.string.expand_text));

        //initMaxMemory
        initMaxMemory();
    }

    /**
     * 初始化textview
     */
    private void initMaxMemory() {
        tv_maxMemory = (TextView) findViewById(R.id.tv_maxMemory);
        double maxMemory = Runtime.getRuntime().maxMemory()/1024/1024;
        //颜色修改
        String str = ""+maxMemory;
        SpannableString sp = new SpannableString(str);
        sp.setSpan(new ForegroundColorSpan(Color.RED), 0, 5, Spannable
                .SPAN_EXCLUSIVE_INCLUSIVE);
        tv_maxMemory.setText(sp);

        //textview动画
        hTextView = (HTextView) findViewById(R.id.htext);
        hTextView.animateText("Evan");
    }
}

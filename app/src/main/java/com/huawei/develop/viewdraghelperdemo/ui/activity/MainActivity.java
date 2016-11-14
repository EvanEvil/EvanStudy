package com.huawei.develop.viewdraghelperdemo.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.huawei.develop.viewdraghelperdemo.R;
import com.huawei.develop.viewdraghelperdemo.ui.fragment.Find;
import com.huawei.develop.viewdraghelperdemo.ui.fragment.HomeFragment;
import com.huawei.develop.viewdraghelperdemo.ui.fragment.Mine;
import com.huawei.develop.viewdraghelperdemo.ui.fragment.MyCategory;
import com.huawei.develop.viewdraghelperdemo.ui.fragment.ShoppingCar;
import com.jauker.widget.BadgeView;

/**
 * 1主界面 布局采用 FragmentTabHost
 */
public class MainActivity extends AppCompatActivity {
    //定义FragmentTabHost对象
    private FragmentTabHost mTabHost;
    private int badgeNum = 0;

    //定义一个布局填充器
    private LayoutInflater layoutInflater;

    //定义数组来存放Fragment界面
    private Class fragmentArray[] = {HomeFragment.class, MyCategory.class, Find.class,
            ShoppingCar.class, Mine.class};

    private String texts[] = {"首页", "消息", "好友", "广场", "更多"};
    private int[] images = {R.drawable.sum, R.drawable.monitor, R.drawable.moon, R.drawable
            .mountain, R.drawable.newspaper};


    private BadgeView badgeView;
    private ImageView pic;
    private ImageView temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initData() {
        mTabHost.setup(this, getSupportFragmentManager(), R.id.fl_pager);
        for (int i = 0; i < texts.length; i++) {
            //创建tabSpec
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(texts[i]).setIndicator(getView(i));
            //添加tabSpec
            mTabHost.addTab(tabSpec, fragmentArray[i], null);
        }
        HomeFragment.setOnBadgeButtonClickListener(new HomeFragment.OnBadgeButtonClickListener() {
            @Override
            public void onBadgeNumButtonClick() {
                badgeView.setTargetView(temp);
                badgeView.setBadgeCount(++badgeNum);
                badgeView.setBackground(12, Color.parseColor("#ff0000"));
                badgeView.setBadgeGravity(Gravity.TOP|Gravity.RIGHT);
                badgeView.setText("呵呵");


            }
        });

    }

    private View getView(int position) {
        View view = View.inflate(this, R.layout.tab_bottom, null);
        TextView text = (TextView) view.findViewById(R.id.tv_title);
        pic = (ImageView) view.findViewById(R.id.iv_pic);
        text.setText(texts[position]);
        pic.setImageResource(images[position]);

        if(position ==0){
            temp = pic;
        }

        return view;
    }

    private void initView() {
        mTabHost = (FragmentTabHost) findViewById(R.id.ft_tabhost);
        badgeView = new BadgeView(this);

    }


}

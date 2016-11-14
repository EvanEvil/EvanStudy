package com.huawei.develop.viewdraghelperdemo.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.huawei.develop.viewdraghelperdemo.R;
import com.huawei.develop.viewdraghelperdemo.ui.activity.MyMaterialDesignActivity;
import com.huawei.develop.viewdraghelperdemo.ui.activity.MyTextViewActivity;
import com.huawei.develop.viewdraghelperdemo.ui.activity.MyVideoView;

/**
 * Created by Evan on 2016/10/14.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private Button btn_recyclerView_add;
    private View rootView;
    private TextView tv_maxMemory;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //初始化根布局
        rootView = View.inflate(getContext(), R.layout.tab_home, null);

        //FloatingActionButton
        final FloatingActionButton floatingActionButton = (FloatingActionButton) rootView.findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(floatingActionButton,"hello world",Snackbar.LENGTH_SHORT).show();
            }
        });
        initView();


        return rootView;
    }

    private void initView() {
        Button btn_text = (Button) rootView.findViewById(R.id.btn_textview);
        Button btn_video = (Button) rootView.findViewById(R.id.btn_video);
        Button getScreenSize = (Button) rootView.findViewById(R.id.getScreenSize);
        Button btn_sentBadgeNum = (Button) rootView.findViewById(R.id.btn_sentBadgeNum);
        Button btn_navigationbar = (Button) rootView.findViewById(R.id.btn_navigationbar);
        Button btn_systembroswer = (Button) rootView.findViewById(R.id.btn_systembroswer);
        Button btn_qqbroswer = (Button) rootView.findViewById(R.id.btn_qqbroswer);
        Button btn_toast = (Button) rootView.findViewById(R.id.btn_toast);
        btn_text.setOnClickListener(this);
        btn_video.setOnClickListener(this);
        getScreenSize.setOnClickListener(this);
        btn_sentBadgeNum.setOnClickListener(this);
        btn_navigationbar.setOnClickListener(this);
        btn_systembroswer.setOnClickListener(this);
        btn_qqbroswer.setOnClickListener(this);
        btn_toast.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_textview:

                startActivity(new Intent(getContext(), MyTextViewActivity.class));
                break;
            case R.id.btn_video:

                startActivity(new Intent(getContext(), MyVideoView.class));
                break;
            //获取屏幕宽高
            case R.id.getScreenSize:
                Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
                int width = defaultDisplay.getWidth();
                int height = defaultDisplay.getHeight();
                Toast.makeText(getContext(),"屏幕宽度:"+width+",屏幕高度:"+height,Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sentBadgeNum:
                mOnBadgeButtonClickListener.onBadgeNumButtonClick();
                break;
            case R.id.btn_navigationbar:
                startActivity(new Intent(getContext(),MyMaterialDesignActivity.class));
                break;
            case R.id.btn_systembroswer:
                startBroswer(0);
                break;
            case R.id.btn_qqbroswer:
                startBroswer(1);
                break;
            case R.id.btn_toast:
                Toast.makeText(getContext(),"hello",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void startBroswer(int i) {
        if(i==0){
            //打开系统浏览器
            Intent intent =new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri content_url =Uri.parse("http://www.qq.com");
            intent.setData(content_url);
            startActivity(intent);
        }else if(i==1){
            Intent intent =new Intent();
            intent.setAction("android.intent.action.VIEW");
            Uri content_url =Uri.parse("http://www.qq.com");
            intent.setData(content_url);
           intent.setClassName("com.tencent.mtt", "com.tencent.mtt.MainActivity");
            //UC浏览器不存在,会报异常,并终止程序
           // intent.setClassName("com.uc.browser", "com.uc.browser.ActivityUpdate");

            startActivity(intent);
        }
    }

    //接口回调
    static OnBadgeButtonClickListener mOnBadgeButtonClickListener;

    public interface OnBadgeButtonClickListener{
        public void onBadgeNumButtonClick();
}
    public static void setOnBadgeButtonClickListener(OnBadgeButtonClickListener badgeButtonClickListener){
        mOnBadgeButtonClickListener = badgeButtonClickListener;
    }
}

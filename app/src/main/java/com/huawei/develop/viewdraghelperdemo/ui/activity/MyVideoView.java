package com.huawei.develop.viewdraghelperdemo.ui.activity;

import android.os.Environment;
import android.view.View;
import android.widget.ListView;

import com.huawei.develop.viewdraghelperdemo.R;
import com.huawei.develop.viewdraghelperdemo.adapter.JiecaoViewAdapter;
import com.huawei.develop.viewdraghelperdemo.base.BaseActivity;
import com.huawei.develop.viewdraghelperdemo.bean.JiecaoBean;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class MyVideoView extends BaseActivity {


    private ListView vedioListView;
    private List<JiecaoBean> list;
    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        initListResource();
        vedioListView.setAdapter(new JiecaoViewAdapter(list,this));
    }

    private void initListResource() {
       for(int i=0; i<10; i++){
           JiecaoBean jiecaoBean = new JiecaoBean();
           jiecaoBean.setPath(Environment.getExternalStorageDirectory() + "/Download/B.mp4");
           jiecaoBean.setViewTitle("美女脱衣");
           list.add(jiecaoBean);
       }
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_my_video_view);
        vedioListView = (ListView) findViewById(R.id.vedioListView);
        list = new ArrayList<>();
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}

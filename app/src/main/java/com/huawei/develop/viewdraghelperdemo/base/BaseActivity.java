package com.huawei.develop.viewdraghelperdemo.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Evan on 2016/11/8.
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        initView();
        initListener();
        initData();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();
}

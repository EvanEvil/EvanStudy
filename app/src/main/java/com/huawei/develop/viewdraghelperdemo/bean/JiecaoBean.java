package com.huawei.develop.viewdraghelperdemo.bean;

import android.widget.ImageView;

/**
 * Created by Evan on 2016/11/8.
 */
public class JiecaoBean {
    public String path;
    public ImageView thumbnail;
    public String viewTitle;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public ImageView getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageView thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getViewTitle() {
        return viewTitle;
    }

    public void setViewTitle(String viewTitle) {
        this.viewTitle = viewTitle;
    }
}

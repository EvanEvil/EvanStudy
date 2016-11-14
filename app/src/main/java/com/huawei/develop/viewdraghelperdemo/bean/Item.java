package com.huawei.develop.viewdraghelperdemo.bean;

/**
 * Created by Evan on 2016/10/24.
 */
public class Item {
    private String maintitle;
    private String subtitle;

    public Item(String maintitle, String subtitle){
        this.maintitle = maintitle;
        this.subtitle = subtitle;
    }

    public String getMaintitle() {
        return maintitle;
    }

    public String getSubtitle() {
        return subtitle;
    }
}

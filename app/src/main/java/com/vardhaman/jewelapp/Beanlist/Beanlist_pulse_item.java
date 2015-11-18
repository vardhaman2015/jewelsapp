package com.vardhaman.jewelapp.Beanlist;

/**
 * Created by android on 10/31/2015.
 */
public class Beanlist_pulse_item {

    public Beanlist_pulse_item(String text1, String text2){
        name = text1;
        productname = text2;
    }

    String name,productname,dimquality,time,metal,pricerange;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getDimquality() {
        return dimquality;
    }

    public void setDimquality(String dimquality) {
        this.dimquality = dimquality;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public String getPricerange() {
        return pricerange;
    }

    public void setPricerange(String pricerange) {
        this.pricerange = pricerange;
    }
}

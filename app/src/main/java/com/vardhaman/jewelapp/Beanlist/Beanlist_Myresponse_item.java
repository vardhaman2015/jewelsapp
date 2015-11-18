package com.vardhaman.jewelapp.Beanlist;

/**
 * Created by vardhaman on 9/26/2015.
 */
public class Beanlist_Myresponse_item {



    String product_name;
    String product_type;
    String name;
    String mobileno;
    String pricerange;
    String image;



    public Beanlist_Myresponse_item (String text1, String text2){
        name = text1;
        product_name = text2;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPricerange() {
        return pricerange;
    }

    public void setPricerange(String pricerange) {
        this.pricerange = pricerange;
    }


}

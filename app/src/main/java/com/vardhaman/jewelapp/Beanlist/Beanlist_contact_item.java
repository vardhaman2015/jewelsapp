package com.vardhaman.jewelapp.Beanlist;

/**
 * Created by vardhaman on 9/30/2015.
 */
public class Beanlist_contact_item {
    String name[];
    String image;
    String phoneno[];

    public Beanlist_contact_item (String text1[], String text2[]){
        name = text1;
        phoneno = text2;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String[] getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String[] phoneno) {
        this.phoneno = phoneno;
    }


}

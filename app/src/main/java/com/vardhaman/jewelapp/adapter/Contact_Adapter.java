package com.vardhaman.jewelapp.adapter;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.vardhaman.jewelapp.Beanlist.Beanlist_Myresponse_item;
import com.vardhaman.jewelapp.Beanlist.Beanlist_contact_item;
import com.vardhaman.jewelapp.R;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;


public class Contact_Adapter extends RecyclerView.Adapter<Contact_Adapter.DataObjectHolder> {
    private static String LOG_TAG = "ContactAdapter";
    private ArrayList<Beanlist_contact_item> mDataset;
    private static MyClickListener myClickListener;
    private static Context rcontext;


    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        private android.widget.ImageView contactimage;
        private TextView contactname;
        private TextView contactno;
        private android.widget.Button invite;



        public DataObjectHolder(View itemView) {
            super(itemView);


            this.invite = (Button) itemView.findViewById(R.id.invite);
            this.contactno = (TextView) itemView.findViewById(R.id.contactno);
            this.contactname = (TextView) itemView.findViewById(R.id.contactname);
            this.contactimage = (ImageView) itemView.findViewById(R.id.contactimage);


            Log.i(LOG_TAG, "Adding Listener");
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


            Log.i(LOG_TAG, "on click");

            myClickListener.onItemClick(getPosition(), v);

        }
    }




    public void setOnItemClickListener(MyClickListener myClickListener) {

        Log.i(LOG_TAG, "OnItemClickListener");

        this.myClickListener = myClickListener;
    }

    public Contact_Adapter(ArrayList<Beanlist_contact_item> myDataset,Context context) {

        mDataset = myDataset;
        rcontext = context;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_list_item, parent, false);



        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }


    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
        Cursor contacts =rcontext.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);



        for(int i=0;i<=contacts.getCount();i++){

            holder.contactname.setText(mDataset.get(position).getName().toString());
            holder.contactno.setText(mDataset.get(position).getPhoneno().toString());

        }
       // holder.contactimage.setImageBitmap(mDataset.get(position).getImage());

        if(getByteContactPhonto(mDataset.get(position).getImage())==null){
            holder.contactimage.setImageResource(R.drawable.avatar);
        }else{
            holder.contactimage.setImageBitmap(getByteContactPhonto(mDataset.get(position).getImage()));
        }


    }

    public void addItem(Beanlist_contact_item dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }


    public Bitmap getByteContactPhonto(String contactId) {
//        grantUriPermissio();
        Uri contactUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, Long.parseLong(contactId));
        Uri photoUri = Uri.withAppendedPath(contactUri, ContactsContract.Contacts.Photo.CONTENT_DIRECTORY);
        Cursor cursor = rcontext.getContentResolver().query(photoUri,
                new String[]{ContactsContract.Contacts.Photo.PHOTO}, null, null, null);

//        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
//        Log.d("name",name);
        if (cursor == null) {
            return null;
        }
        try {
            if (cursor.moveToFirst()) {
                byte[] data = cursor.getBlob(0);
                if (data != null) {
                    return BitmapFactory.decodeStream(new ByteArrayInputStream(data));
                }
            }
        } finally {
            cursor.close();
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {

        public void onItemClick(int position, View v);
    }
}

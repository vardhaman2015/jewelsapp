package com.vardhaman.jewelapp.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.vardhaman.jewelapp.Beanlist.Beanlist_Myresponse_item;
import com.vardhaman.jewelapp.Beanlist.Beanlist_post_item;
import com.vardhaman.jewelapp.R;

import java.util.ArrayList;


public class My_Response_Adapter extends RecyclerView.Adapter<My_Response_Adapter.DataObjectHolder> {
    private static String LOG_TAG = "My_Response_Adapter";
    private ArrayList<Beanlist_Myresponse_item> mDataset;
    private static MyClickListener myClickListener;
    private static Context rcontext;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        private com.github.siyamed.shapeimageview.CircularImageView profileimageview;
        private TextView tvnameres;
        private TextView tvmobileres;
        private TextView tvpriceres;
        private TextView tvproductname;
        private TextView tvproducttype;



        public DataObjectHolder(View itemView) {
            super(itemView);



            this.tvproducttype = (TextView) itemView.findViewById(R.id.tvproducttype);
            this.tvproductname = (TextView) itemView.findViewById(R.id.tvproductname);
            this.tvpriceres = (TextView) itemView.findViewById(R.id.tvpriceres);
            this.tvmobileres = (TextView) itemView.findViewById(R.id.tvmobileres);
            this.tvnameres = (TextView) itemView.findViewById(R.id.tvnameres);
            this.profileimageview = (CircularImageView) itemView.findViewById(R.id.profile_imageview);

            // tvproduct_name = (TextView)itemView.findViewById(R.id.tvproduct_name);



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

    public My_Response_Adapter(ArrayList<Beanlist_Myresponse_item> myDataset) {

        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.response_list_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }


    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.tvproductname.setText(mDataset.get(position).getProduct_name());
        holder.tvproducttype.setText(mDataset.get(position).getProduct_type());
        holder.tvmobileres.setText(mDataset.get(position).getMobileno());
        holder.tvnameres.setText(mDataset.get(position).getName());
        holder.tvpriceres.setText(mDataset.get(position).getPricerange());
        //holder.profileimageview.setText(mDataset.get(position).getProduct_name());











    }

    public void addItem(Beanlist_Myresponse_item dataObj, int index) {
        mDataset.add(dataObj);
        notifyItemInserted(index);
    }

    public void deleteItem(int index) {
        mDataset.remove(index);
        notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public interface MyClickListener {

        public void onItemClick(int position, View v);
    }
}
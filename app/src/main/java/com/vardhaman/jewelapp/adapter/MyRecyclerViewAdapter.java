package com.vardhaman.jewelapp.adapter;

/**
 * Created by vardhaman on 9/14/2015.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vardhaman.jewelapp.Beanlist.Beanlist_post_item;
import com.vardhaman.jewelapp.R;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.DataObjectHolder> {
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private ArrayList<Beanlist_post_item> mDataset;
    private static MyClickListener myClickListener;
    private static  Context rcontext;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        TextView tvproduct_name,tvshape,tvsize,tvcolor,tvclarity,tvcut,tvquantity,tvpricerange,viewresponse;
        ImageView itemimage;

        public DataObjectHolder(View itemView) {
            super(itemView);

            tvproduct_name = (TextView)itemView.findViewById(R.id.tvproduct_name);
            tvshape = (TextView) itemView.findViewById(R.id.tvshape);
            tvsize = (TextView) itemView.findViewById(R.id.tvsize);
            tvcolor = (TextView) itemView.findViewById(R.id.tvcolor);
            tvclarity = (TextView) itemView.findViewById(R.id.tvclarity);
            tvcut = (TextView) itemView.findViewById(R.id.tvcut);
            tvquantity = (TextView) itemView.findViewById(R.id.tvquantity);
            tvpricerange = (TextView) itemView.findViewById(R.id.tvprice_range);
            viewresponse = (TextView) itemView.findViewById(R.id.view_response);
            itemimage = (ImageView) itemView.findViewById(R.id.item_image);


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

    public MyRecyclerViewAdapter(ArrayList<Beanlist_post_item> myDataset) {

        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);

        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {
     holder.tvshape.setText(mDataset.get(position).getShape());
        holder.tvsize.setText(mDataset.get(position).getSize());
        holder.tvcolor.setText(mDataset.get(position).getColor());
        holder.tvclarity.setText(mDataset.get(position).getClarity());
        holder.tvcut.setText(mDataset.get(position).getCut());
        holder.tvquantity.setText(mDataset.get(position).getQuantity());
        holder.tvpricerange.setText(mDataset.get(position).getPrice_range());
        holder.tvproduct_name.setText(mDataset.get(position).getProduct_name());
        //holder.itemimage.setText(mDataset.get(position).getShape());







        // holder.dateTime.setText(mDataset.get(position).getmText2());
    }

    public void addItem(Beanlist_post_item dataObj, int index) {
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
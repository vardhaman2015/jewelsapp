package com.vardhaman.jewelapp.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.vardhaman.jewelapp.Beanlist.Beanlist_Myresponse_item;
import com.vardhaman.jewelapp.Beanlist.Beanlist_pulse_item;
import com.vardhaman.jewelapp.Beanlist.Constant;
import com.vardhaman.jewelapp.Fragment.DiamondFragment;
import com.vardhaman.jewelapp.Fragment.GemsStoneFragment;
import com.vardhaman.jewelapp.Fragment.JewelleryFragment;
import com.vardhaman.jewelapp.R;

import java.util.ArrayList;


public class PulseAdapter extends RecyclerView.Adapter<PulseAdapter.DataObjectHolder> {
    private static String LOG_TAG = "PulseAdapter";
    private ArrayList<Beanlist_pulse_item> mDataset;
    private static MyClickListener myClickListener;
    private static Context rcontext;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    Activity activity;


    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {

        private TextView tvnamep;
        private TextView tvproductp;
        private TextView tvdimquality;
        private TextView tvtimep;
        private TextView tvmetalp;
        private TextView tvpricerangep;
        public static TextView tvaddresponse;
        private CardView cv;


        public DataObjectHolder(View itemView) {
            super(itemView);

            this.cv = (CardView) itemView.findViewById(R.id.cv);
            this.tvaddresponse = (TextView) itemView.findViewById(R.id.tvaddresponse);
            this.tvpricerangep = (TextView) itemView.findViewById(R.id.tvpricerangep);
            this.tvmetalp = (TextView) itemView.findViewById(R.id.tvmetalp);
            this.tvtimep = (TextView) itemView.findViewById(R.id.tvtimep);
            this.tvdimquality = (TextView) itemView.findViewById(R.id.tvdimquality);
            this.tvproductp = (TextView) itemView.findViewById(R.id.tvproductname);
            this.tvnamep = (TextView) itemView.findViewById(R.id.tvnamep);



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

    public PulseAdapter(ArrayList<Beanlist_pulse_item> myDataset,Activity activity) {

        this.activity  = activity;
        mDataset = myDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pulse_item, parent, false);


        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }


    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.tvnamep.setText(mDataset.get(position).getName());
        holder.tvproductp.setText(mDataset.get(position).getProductname());
        final String productname = mDataset.get(position).getProductname();
        holder.tvdimquality.setText(mDataset.get(position).getDimquality());
        holder.tvmetalp.setText(mDataset.get(position).getMetal());
        holder.tvpricerangep.setText(mDataset.get(position).getPricerange());
        holder.tvtimep.setText(mDataset.get(position).getTime());


        fragmentManager = activity.getFragmentManager();

        holder.tvaddresponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(productname.equalsIgnoreCase("diamond")){

                    Constant.from_pulse=true;
                    fragment = new DiamondFragment();

                    if (fragment != null) {
                        fragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack("Diamond").commit();

                    }

                }else if(productname.equalsIgnoreCase("jewellery"))
                {
                    Constant.from_pulse=true;

                    fragment = new JewelleryFragment();

                    if (fragment != null) {
                        fragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack("Jewellery").commit();

                    }

                }else {

                    Constant.from_pulse=true;

                    fragment = new GemsStoneFragment();

                    if (fragment != null) {
                        fragmentManager.beginTransaction().replace(R.id.container, fragment).addToBackStack("GemsStones").commit();

                    }

                }
            }
        });




        //holder.profileimageview.setText(mDataset.get(position).getProduct_name());











    }

    public void addItem(Beanlist_pulse_item dataObj, int index) {
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

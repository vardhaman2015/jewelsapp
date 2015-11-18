package com.vardhaman.jewelapp.Fragment;

import android.app.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vardhaman.jewelapp.Beanlist.Beanlist_post_item;
import com.vardhaman.jewelapp.R;
import com.vardhaman.jewelapp.adapter.MyRecyclerViewAdapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PostFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PostFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PostFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private android.support.v7.widget.RecyclerView myrecyclerviewpost;
    Fragment fragment = null;
    FragmentManager fragmentManager;
    private ArrayList<Beanlist_post_item> mDataset;
    MyRecyclerViewAdapter adapter;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PostFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PostFragment newInstance(String param1, String param2) {
        PostFragment fragment = new PostFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public PostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        this.myrecyclerviewpost = (RecyclerView) view.findViewById(R.id.my_recycler_view_post);


        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myrecyclerviewpost.setHasFixedSize(true);
        myrecyclerviewpost.setLayoutManager(mLinearLayoutManager);
        myrecyclerviewpost.setItemAnimator(new DefaultItemAnimator());
        adapter = new MyRecyclerViewAdapter(getDataSet());

        myrecyclerviewpost.setAdapter(adapter);


        return  view;
    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MyRecyclerViewAdapter) adapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {


                android.app.FragmentManager fragmentManager = getFragmentManager();
                Fragment fragment = null;
                fragment = new Post_ResponseFragment();

                if (fragment != null) {
                    fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
                }
                Log.d("post fragment", " Clicked on Item " + position);

            }
        });
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private ArrayList<Beanlist_post_item> getDataSet() {
       ArrayList results = new ArrayList<Beanlist_post_item>();
        for (int index = 0; index < 5; index++) {
            Beanlist_post_item obj = new Beanlist_post_item("round","3");
            results.add(index, obj);
        }
        return results;
    }

}

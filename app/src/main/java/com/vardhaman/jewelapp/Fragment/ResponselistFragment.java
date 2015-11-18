package com.vardhaman.jewelapp.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.siyamed.shapeimageview.CircularImageView;
import com.vardhaman.jewelapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResponselistFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResponselistFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private com.github.siyamed.shapeimageview.CircularImageView profileimageview;
    private android.widget.TextView tvnameres;
    private android.widget.TextView tvmobileres;
    private android.widget.TextView tvpriceres;
    private android.widget.LinearLayout responselinearlayout;
    Fragment fragment = null;
    FragmentManager fragmentManager;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResponselistFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResponselistFragment newInstance(String param1, String param2) {
        ResponselistFragment fragment = new ResponselistFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ResponselistFragment() {
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
        View v= inflater.inflate(R.layout.response_list_item, container, false);
        this.responselinearlayout = (LinearLayout) v.findViewById(R.id.response_linearlayout);
        this.tvpriceres = (TextView) v.findViewById(R.id.tvpriceres);
        this.tvmobileres = (TextView) v.findViewById(R.id.tvmobileres);
        this.tvnameres = (TextView) v.findViewById(R.id.tvnameres);
        this.profileimageview = (CircularImageView) v.findViewById(R.id.profile_imageview);

        profileimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentManager = getFragmentManager();

                fragment = new Post_ResponseFragment();

                if (fragment != null) {
                    fragmentManager.beginTransaction().replace(R.id.container_response_item, fragment).commit();

                }
            }
        });

        return v;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

}

package com.vardhaman.jewelapp.Fragment;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.ContactsContract;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vardhaman.jewelapp.Beanlist.Beanlist_Myresponse_item;
import com.vardhaman.jewelapp.Beanlist.Beanlist_contact_item;
import com.vardhaman.jewelapp.R;
import com.vardhaman.jewelapp.adapter.Contact_Adapter;
import com.vardhaman.jewelapp.adapter.My_Response_Adapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link InviteContactFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link InviteContactFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InviteContactFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private android.support.v7.widget.RecyclerView myrecyclerviewcontact;
    Contact_Adapter adapter;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InviteContactFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InviteContactFragment newInstance(String param1, String param2) {
        InviteContactFragment fragment = new InviteContactFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public InviteContactFragment() {
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
        View v = inflater.inflate(R.layout.fragment_invite_contact, container, false);
        this.myrecyclerviewcontact = (RecyclerView) v.findViewById(R.id.contact_recycler_view);

        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myrecyclerviewcontact.setHasFixedSize(true);
        myrecyclerviewcontact.setLayoutManager(mLinearLayoutManager);
        myrecyclerviewcontact.setItemAnimator(new DefaultItemAnimator());
        adapter = new Contact_Adapter(getDataSet(),getActivity());

        myrecyclerviewcontact.setAdapter(adapter);

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

    private ArrayList<Beanlist_contact_item> getDataSet() {
        ArrayList results = new ArrayList<Beanlist_contact_item>();
//        String name[]={""},phoneNumber[]={""};
//        int i=0;

      /*  Cursor phones = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (phones.moveToNext())
        {
             name[i] = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneNumber[i] = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Toast.makeText(getActivity().getApplicationContext(), name.toString(), Toast.LENGTH_LONG).show();
            i++;


        }
        phones.close();
*/


        Cursor contacts = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        String aNameFromContacts[] = new String[contacts.getCount()];
        String aNumberFromContacts[] = new String[contacts.getCount()];
        int i = 0;

        int nameFieldColumnIndex = contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
        int numberFieldColumnIndex = contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);

        while(contacts.moveToNext()) {

//            String contactName = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME););
            String contactName = contacts.getString(nameFieldColumnIndex);
            aNameFromContacts[i] =    contactName ;

//            String number = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER););
            String number = contacts.getString(numberFieldColumnIndex);
            aNumberFromContacts[i] =    number ;
            i++;
        }

        for (int index = 0; index <contacts.getCount() ; index++) {
            Beanlist_contact_item obj = new Beanlist_contact_item(aNameFromContacts,aNumberFromContacts);
            results.add(index, obj);
        }
        contacts.close();
        return results;
    }

}

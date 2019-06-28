package com.example.helloviewpager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class BlueFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    TextView tvBlue;
    Button btnSwipeBlue;

    private OnFragmentInteractionListener mListener;

    public BlueFragment() {
        // Required empty public constructor
    }


    public static BlueFragment newInstance(String param1, String param2) {
        BlueFragment fragment = new BlueFragment();
        Bundle args = new Bundle();
        //args.putString(, param1);
        //args.putString(btnSwipeBlue, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewBlueFragment = inflater.inflate(R.layout.fragment_blue, container, false);

        btnSwipeBlue = viewBlueFragment.findViewById(R.id.btnBlue);

        btnSwipeBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSwipeBlue();
            }
        });

        return viewBlueFragment;
    }


    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onSwipeBlue();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onSwipeBlue();
    }
}

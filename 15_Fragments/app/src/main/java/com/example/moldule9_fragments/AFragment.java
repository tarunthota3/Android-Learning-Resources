package com.example.moldule9_fragments;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    private static final String TAG = "demo";

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        view.findViewById(R.id.buttonClickMe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, " Button Clicked");
            }
        });

        return view;
    }

    OnFragmentTextChange mListener;
    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentTextChange) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " should implement OnFragmentTextChange");
        }



    }

    public void changeColor(int color){
        getView().findViewById(R.id.fragment_root).setBackgroundColor(color);
//        getActivity().findViewById(R.id.fragment_root).setBackgroundColor(color);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        getActivity().findViewById(R.id.buttonClickMe).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d(TAG, "Button Clicked");
//            }
//        });




        getActivity().findViewById(R.id.buttonInFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et = getActivity().findViewById(R.id.editTextInFragment);
                mListener.onTextChanged(et.getText().toString());
            }
        });
    }

    public interface OnFragmentTextChange{
        void onTextChanged(String text);
    }
}

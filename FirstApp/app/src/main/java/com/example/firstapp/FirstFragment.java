package com.example.firstapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


public class FirstFragment extends Fragment {
EditText editText;
private static final String FragTag="Fragment";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(FragTag,"On create from fragment called");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i(FragTag,"On createview from fragment called");
        View view= inflater.inflate(R.layout.fragment_first, container, false);
      editText = view.findViewById(R.id.etUserName);

        editText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {

                Toast.makeText(getContext().getApplicationContext(), "in fragment afterTextchanged event", Toast.LENGTH_SHORT).show();
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                Toast.makeText(getContext().getApplicationContext(), "in fragment before text changed event", Toast.LENGTH_SHORT).show();

            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });

      //  return inflater.inflate(R.layout.fragment_first, container, false);


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i(FragTag,"On attach from fragment called");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(FragTag,"On activity created from fragment called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(FragTag,"On stop from fragment called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(FragTag,"On start from fragment called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(FragTag,"On destroy from fragment called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(FragTag,"On resume from fragment called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(FragTag,"On pause from fragment called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(FragTag,"On destroyview from fragment called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(FragTag,"On detach from fragment called");
    }
}
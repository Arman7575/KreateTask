package com.example.myapplication.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.interfaces.IManActivityCallback;

public class FragmentTwo extends Fragment {

    EditText et_one;
    Button btn_enter;
    IManActivityCallback IManActivityCallback;

    public FragmentTwo() {
        // Required empty public constructor
    }

    public static FragmentTwo newInstance(String param1, String param2) {
        FragmentTwo fragment = new FragmentTwo();
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
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_one = view.findViewById(R.id.et_one);
        btn_enter = view.findViewById(R.id.btn_enter);

        btn_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(et_one.getText().toString().trim())) {
                    Toast.makeText(getContext(), "Please enter something first", Toast.LENGTH_SHORT).show();
                } else {
                    String text = et_one.getText().toString().trim();
                    IManActivityCallback.onTextChanged("FragmentTwo :" +" "+text);
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        IManActivityCallback = (IManActivityCallback) context;
    }
}
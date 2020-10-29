package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.fragments.MainFragment;
import com.example.myapplication.interfaces.IManActivityCallback;

public class MainActivity extends AppCompatActivity implements IManActivityCallback {
    private TextView txtHeader;
    Fragment fragmentCurrent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        txtHeader = findViewById(R.id.txtHeader);
        addFragment(MainFragment.newInstance());
    }

    public void addFragment(Fragment fragment) {
        fragmentCurrent = fragment;
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.content, fragment);
        ft.commit();
    }

    @Override
    public void onTextChanged(String text) {
        txtHeader.setText(text);
    }
}
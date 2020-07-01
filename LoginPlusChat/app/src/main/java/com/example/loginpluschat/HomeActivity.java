package com.example.loginpluschat;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView rvHome;
    private EditText etSearch;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intiView();
        setRecyclerView();
    }

    private void setRecyclerView() {
        mAdapter = new HomeAdapter(this );
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvHome.setLayoutManager(mLayoutManager);
        rvHome.setItemAnimator(new DefaultItemAnimator());
        rvHome.setAdapter(mAdapter);

    }

    private void intiView() {
        rvHome = findViewById(R.id.rv_home);
        etSearch = findViewById(R.id.et_search);
    }
}

package com.example.loginpluschat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChatActivity extends AppCompatActivity {
    private RecyclerView rvMsgList;
    private EditText etChatBox;
    private Button btnSendChatBox;
    private MessageListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initView();
        setRecyclerView();
        setListeners();
    }

    private void setRecyclerView() {
        mAdapter = new MessageListAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvMsgList.setLayoutManager(mLayoutManager);
        rvMsgList.setItemAnimator(new DefaultItemAnimator());
        rvMsgList.setAdapter(mAdapter);
    }

    private void setListeners() {
        btnSendChatBox.setOnClickListener(v -> {

        });
    }

    private void initView() {
        rvMsgList = findViewById(R.id.rv_msg_list);
        etChatBox = findViewById(R.id.et_chat_box);
        btnSendChatBox = findViewById(R.id.btn_send_chat_box);
    }
}
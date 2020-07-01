package com.example.loginpluschat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MessageListAdapter extends RecyclerView.Adapter {

    private static final int MESSAGE_RECEIVE = 1;
    private static final int MESSAGE_SENT = 2;
    private final Context context;

    MessageListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == MESSAGE_RECEIVE) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_receive, parent, false);
            return new MessageReceiveHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_message_sent, parent, false);
            return new MessageSentHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == MESSAGE_RECEIVE) {
            ((MessageReceiveHolder) holder).tvReceiveName.setText("Receiver");
            ((MessageReceiveHolder) holder).tvReceiveBody.setText("Hi! I am fine");
            ((MessageReceiveHolder) holder).tvReceiveTime.setText("10:50");
        } else {
            ((MessageSentHolder) holder).tvSentBody.setText("Hi! How are you");
            ((MessageSentHolder) holder).tvSentTime.setText("10:51");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        int s = 101;
        if (s + position != 101) {
            return MESSAGE_SENT;
        } else {
            return MESSAGE_RECEIVE;
        }
    }

    private class MessageReceiveHolder extends RecyclerView.ViewHolder {
        private final TextView tvReceiveName;
        private final TextView tvReceiveBody;
        private final TextView tvReceiveTime;

        public MessageReceiveHolder(@NonNull View itemView) {
            super(itemView);
            tvReceiveName = itemView.findViewById(R.id.tv_receive_name);
            tvReceiveBody = itemView.findViewById(R.id.tv_receive_body);
            tvReceiveTime = itemView.findViewById(R.id.tv_receive_time);
        }
    }

    private class MessageSentHolder extends RecyclerView.ViewHolder {
        private final TextView tvSentBody;
        private final TextView tvSentTime;

        public MessageSentHolder(View view) {
            super(view);
            tvSentBody = view.findViewById(R.id.tv_sent_body);
            tvSentTime = view.findViewById(R.id.tv_sent_time);
        }
    }
}

package com.example.loginpluschat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class HomeAdapter extends RecyclerView.Adapter {
    private Context context;

    HomeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_list_item, parent, false);

        return new HomeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((HomeViewHolder) holder).tvName.setText("slfjsfjslf");
        ((HomeViewHolder) holder).tvTitle.setText("slfjsfjslf");
        ((HomeViewHolder) holder).ivCard.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_search_black_24dp));

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    private class HomeViewHolder extends RecyclerView.ViewHolder {
        private final View rvClick;
        private ImageView ivCard;
        private TextView tvName;
        private TextView tvTitle;

        HomeViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivCard = itemView.findViewById(R.id.iv_card);
            rvClick = itemView.findViewById(R.id.rv_click);

            rvClick.setOnClickListener(v -> {
                Intent intent = new Intent(context, ChatActivity.class);
                context.startActivity(intent);
            });
        }
    }
}

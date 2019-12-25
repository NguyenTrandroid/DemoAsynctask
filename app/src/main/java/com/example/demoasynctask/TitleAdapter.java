package com.example.demoasynctask;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.ViewHolder> {
    Context context;
    List<Item> itemList;

    public TitleAdapter(Context context, List<Item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public TitleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_title, parent, false);
        return new TitleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TitleAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(itemList.get(position).getTitle());

        DataAdapter dataAdapter = new DataAdapter(context, itemList.get(position).getData());
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.rvData.setLayoutManager(layoutManager);
        holder.rvData.setAdapter(dataAdapter);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        RecyclerView rvData;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            rvData = itemView.findViewById(R.id.rv_data);

        }
    }
}

package com.example.demoasynctask;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    Context context;
    List<Drink> drinkList;

    public DataAdapter(Context context, List<Drink> drinkList) {
        this.context = context;
        this.drinkList = drinkList;
    }

    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_data, parent, false);
        return new DataAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
        holder.tvNameData.setText(drinkList.get(position).getName());
        holder.tvPrice.setText(drinkList.get(position).getPrice()+"");
        Glide.with(context).load(drinkList.get(position).getImageURL()).into(holder.imgData);

    }

    @Override
    public int getItemCount() {
        return drinkList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvNameData,tvPrice;
        ImageView imgData;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgData = itemView.findViewById(R.id.img_data);
            tvNameData = itemView.findViewById(R.id.tv_nameData);
            tvPrice = itemView.findViewById(R.id.tv_price);

        }
    }
}

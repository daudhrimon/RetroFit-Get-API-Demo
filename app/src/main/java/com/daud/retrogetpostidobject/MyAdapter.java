package com.daud.retrogetpostidobject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<AdapterMc> List;

    public MyAdapter(Context context, java.util.List<AdapterMc> list) {
        this.context = context;
        List = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userIdTv.setText("postId: "+List.get(position).getUserId());
        holder.idTv.setText("id: "+List.get(position).getId());
        holder.titleTv.setText("name: "+List.get(position).getTitle());
        holder.bodyTv.setText("body: "+List.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return List.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userIdTv,idTv,titleTv,bodyTv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userIdTv = itemView.findViewById(R.id.userIdTv);
            idTv = itemView.findViewById(R.id.idTv);
            titleTv = itemView.findViewById(R.id.titleTv);
            bodyTv = itemView.findViewById(R.id.bodyTv);
        }
    }
}

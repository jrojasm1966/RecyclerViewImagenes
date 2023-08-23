package com.example.recyclerviewimgenes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

// paso 3 extender de recyclerView
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    // 1 representacion a los datos
    private List<datosLista> dataList;


    // paso 6 crar interface escuche cuando hace un click

    public interface OnItemClickListerner {

        void onItemClick(int position);
    }

    private OnItemClickListerner listener;


    public void setOnClikListener( OnItemClickListerner listener){
        this.listener=listener;
    }

    public Adapter(List<datosLista>dataList){
        this.dataList=dataList;
    }

    // paso 4 inflar la vista del recyclerview
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }


    //npaso 5
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        datosLista data = dataList.get(position);
        int x = position;

        holder.textView.setText(data.getDato());
        Glide.with(holder.itemView).load(data.getUrl()).into(holder.imageView);

        // paso 7 agregar escuchador
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(x);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


// 2 crear clase interna Viewholder

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView2);

        }
    }


}

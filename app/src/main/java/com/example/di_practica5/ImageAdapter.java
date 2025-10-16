package com.example.di_practica5;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.VH> {

    private final List<Integer> imageList;

    public ImageAdapter(List<Integer> imageList) {
        this.imageList = imageList;
    }

    static class VH extends RecyclerView.ViewHolder {
        ImageView imageItem;
        VH(View itemView) {
            super(itemView);
            imageItem = itemView.findViewById(R.id.imageItem);
        }
    }

    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        int resId = imageList.get(position);
        holder.imageItem.setImageResource(resId);

        holder.itemView.setOnClickListener(v -> {
            // Accedemos al ImageSwitcher desde el item (tal como se sugiere en el enunciado)
            ImageSwitcher is = ((Activity) v.getContext()).findViewById(R.id.imageswitcher);
            is.setImageResource(resId);
        });
    }

    @Override
    public int getItemCount() { return imageList.size(); }
}
package com.example.whf_shop.categoryCard;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.whf_shop.R;

public class CategoryCardViewHolder extends RecyclerView.ViewHolder {
    public NetworkImageView categoryImage;
    public TextView categoryTitle;
    public TextView categoryQty;

    public CategoryCardViewHolder(@NonNull View itemView){
        super(itemView);
        categoryImage = itemView.findViewById(R.id.category_image);
        categoryTitle = itemView.findViewById(R.id.category_title);
        categoryQty = itemView.findViewById(R.id.category_qty);
    }
}

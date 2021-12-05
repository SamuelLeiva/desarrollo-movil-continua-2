package com.example.whf_shop.categoryCard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whf_shop.R;
import com.example.whf_shop.network.CategoryEntry;
import com.example.whf_shop.network.ImageRequest;
import com.example.whf_shop.network.ProductEntry;
import com.example.whf_shop.productCard.ProductCardViewHolder;

import java.util.List;

public class CategoryCardRecyclerViewAdapter extends RecyclerView.Adapter<CategoryCardViewHolder>  {
    private List<CategoryEntry> categoryList;
    private ImageRequest imageRequest;

    public CategoryCardRecyclerViewAdapter(List<CategoryEntry> categoryList){
        this.categoryList = categoryList;
        imageRequest = ImageRequest.getInstance();
    }

    @NonNull
    @Override
    public CategoryCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_card, parent, false);
        return new CategoryCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryCardViewHolder holder, int position){
        if(categoryList != null && position < categoryList.size()){
            CategoryEntry category = categoryList.get(position);
            holder.categoryTitle.setText(category.title);
            holder.categoryQty.setText(category.qty);
            imageRequest.setImageFromUrl(holder.categoryImage, category.url);
        }
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}

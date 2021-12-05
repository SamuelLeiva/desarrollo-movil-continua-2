package com.example.whf_shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.whf_shop.categoryCard.CategoryCardRecyclerViewAdapter;
import com.example.whf_shop.network.CategoryEntry;
import com.example.whf_shop.network.ProductEntry;
import com.example.whf_shop.productCard.ProductCardRecyclerViewAdapter;

public class ProductGridFragment extends Fragment {

    //hace que reconozca el bottom menu
    /*private void setUpBottomBar(View view){
        Botto
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
            ){
        View view = inflater.inflate(R.layout.product_grid_fragment, container, false);

        setUpToolbar(view);

        //1er scroll de productos
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_product);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
        ProductCardRecyclerViewAdapter adapter = new ProductCardRecyclerViewAdapter(
                ProductEntry.initProductEntryList(getResources()));
        recyclerView.setAdapter(adapter);
        //recyclerView.addItemDecoration(new Prod);

        //2o scroll de categorias
        RecyclerView recyclerViewCat = view.findViewById(R.id.recycler_view_category);
        recyclerViewCat.setHasFixedSize(true);
        recyclerViewCat.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.HORIZONTAL, false));
        CategoryCardRecyclerViewAdapter catAdapter = new CategoryCardRecyclerViewAdapter(
                CategoryEntry.initCategoryEntryList(getResources()));
        recyclerViewCat.setAdapter(catAdapter);

        return view;
    }

    //hace que reconozca al toolbar de la app
    private void setUpToolbar(View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if(activity != null){
            activity.setSupportActionBar(toolbar);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater){
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
    }
}

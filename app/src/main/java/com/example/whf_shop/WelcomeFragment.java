package com.example.whf_shop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

public class WelcomeFragment extends Fragment {

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
            ){
        View view = inflater.inflate(R.layout.welcome_fragment, container, false);

        MaterialButton logButton = view.findViewById(R.id.log_button);
        MaterialButton exploreButton = view.findViewById(R.id.explore_button);

        logButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ((NavigationHost) getActivity()).navigateTo(new ProductGridFragment(), false);
            }
        });

        exploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((NavigationHost) getActivity()).navigateTo(new ProductGridFragment(), true);
            }
        });

        return view;
    }

}

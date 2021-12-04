package com.example.whf_shop;

import androidx.fragment.app.Fragment;

//eventos de navegacion
public interface NavigationHost {

    void navigateTo(Fragment fragment, boolean addToBackstack);
}

package com.example.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class FragmentPersonadapter extends FragmentPagerAdapter {
    int totaltabs;
    Context context;

    public FragmentPersonadapter(@NonNull FragmentManager fm, int totaltabs, Context context) {
        super(fm);
        this.context = context;
        this.totaltabs = totaltabs;

    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 0:
                centerFragment Center = new centerFragment();
                return Center;
        }
        return null;
    }

    @Override
    public int getCount() {
        return totaltabs;
    }
}

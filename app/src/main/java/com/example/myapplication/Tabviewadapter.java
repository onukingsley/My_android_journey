package com.example.myapplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Tabviewadapter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;

    public Tabviewadapter(@NonNull FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                centerFragment centert = new centerFragment();
                return centert;
            case 2:
                PersonFragment personFragment = new PersonFragment();
            return personFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class PersonFragment extends Fragment {
TabLayout tabLayout;
ViewPager viewpage;


    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_person, container, false);
        viewpage = view.findViewById(R.id.viewp);
        tabLayout =  view.findViewById(R.id.layz);
      /*  tabLayout.addTab(tabLayout.newTab().setText("calls"));
        tabLayout.addTab(tabLayout.newTab().setText("Status"));
        tabLayout.addTab(tabLayout.newTab().setText("call"));*/

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        FragmentPersonadapter fragmentPersonadapter  =  new FragmentPersonadapter(getChildFragmentManager(),  tabLayout.getTabCount(),getContext());
        viewpage.setAdapter(fragmentPersonadapter);
        viewpage.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        return view;
    }
}
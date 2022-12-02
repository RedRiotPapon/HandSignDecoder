package com.example.SignDecoder;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class frag1 extends Fragment {

    ViewPager viewPager;
    ArrayList<Integer> arrayList= new ArrayList<>();
    Context thiscontext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        viewPager = view.findViewById(R.id.viewpager);
        thiscontext = container.getContext();
        arrayList.add(R.drawable.a);
        arrayList.add(R.drawable.b);
        arrayList.add(R.drawable.c);
        homeAdapter homeAdapter = new homeAdapter(thiscontext,arrayList);
        viewPager.setAdapter(homeAdapter);
        return view;
    }
}
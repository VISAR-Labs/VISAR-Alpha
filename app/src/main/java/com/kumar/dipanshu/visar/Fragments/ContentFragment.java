package com.kumar.dipanshu.visar.Fragments;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kumar.dipanshu.visar.R;

public class ContentFragment extends Fragment {

    public ContentFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_content, container, false);
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView physics = (TextView) view.findViewById(R.id.physics);
       // ImageView swiper = (ImageView) view.findViewById(R.id.swiper);

    }
}
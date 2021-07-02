package com.kumar.dipanshu.visar.Fragments;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kumar.dipanshu.visar.R;

public class ThirdMenuFragment extends Fragment implements View.OnClickListener {


    public ThirdMenuFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_third_menu, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button home = (Button) view.findViewById(R.id.unit1);
        Button profile = (Button) view.findViewById(R.id.unit2);
        Button calendar = (Button) view.findViewById(R.id.unit3);
        Button settings = (Button) view.findViewById(R.id.unit4);

        home.setOnClickListener(this);
        profile.setOnClickListener(this);
        calendar.setOnClickListener(this);
        settings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.homeButton:
                Toast.makeText(getContext(), "You clicked HOME", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profileButton:
                Toast.makeText(getContext(), "You clicked PROFILE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.calendarButton:
                Toast.makeText(getContext(), "You clicked CALENDAR", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settingsButton:
                Toast.makeText(getContext(), "You clicked SETTINGS", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
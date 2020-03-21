package com.kumar.dipanshu.visar.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kumar.dipanshu.visar.R;

public class FifthMenuFragment extends Fragment implements View.OnClickListener {


    public FifthMenuFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fifth_menu, container, false);

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
                Toast.makeText(getContext(), "Opening  HOME", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profileButton:
                Toast.makeText(getContext(), "Opening  PROFILE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.calendarButton:
                Toast.makeText(getContext(), "Opening  CALENDAR", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settingsButton:
                Toast.makeText(getContext(), "Opening  SETTINGS", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
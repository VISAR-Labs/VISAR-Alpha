package com.kumar.dipanshu.visar.Fragments;

import android.app.FragmentTransaction;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.kumar.dipanshu.visar.Fragments.mechanics.MechanicsFragment;
import com.kumar.dipanshu.visar.R;

public class FirstMenuFragment extends Fragment implements View.OnClickListener {

    public FirstMenuFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first_menu, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button home = (Button) view.findViewById(R.id.mechanics);
        Button profile = (Button) view.findViewById(R.id.waves);
        Button calendar = (Button) view.findViewById(R.id.elecctromag);
        Button settings = (Button) view.findViewById(R.id.supp);

        home.setOnClickListener(this);
        profile.setOnClickListener(this);
        calendar.setOnClickListener(this);
        settings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mechanics:
                Toast.makeText(getContext(), "Opening  HOME", Toast.LENGTH_SHORT).show();
                changeFragment(new MechanicsFragment());
                break;
            case R.id.waves:
                Toast.makeText(getContext(), "Opening  PROFILE", Toast.LENGTH_SHORT).show();
                break;
            case R.id.elecctromag:
                Toast.makeText(getContext(), "Opening  CALENDAR", Toast.LENGTH_SHORT).show();
                break;
            case R.id.supp:
                Toast.makeText(getContext(), "Opening  SETTINGS", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void changeFragment(Fragment targetFragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentPage, targetFragment, "fragment")
                .addToBackStack(this.toString())
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}
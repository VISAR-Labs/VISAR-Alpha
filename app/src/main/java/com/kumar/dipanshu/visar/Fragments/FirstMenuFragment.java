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

import com.kumar.dipanshu.visar.Fragments.Physics.SWL.SWLFragment;
import com.kumar.dipanshu.visar.Fragments.Physics.mattermatt2.MatterMatt2Fragment;
import com.kumar.dipanshu.visar.Fragments.Physics.mechanics.MechanicsFragment;
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

        Button mechanics = (Button) view.findViewById(R.id.mechanics);
        Button mattermatt2 = view.findViewById(R.id.matter2);
        Button waves = (Button) view.findViewById(R.id.waves);
        Button electromag = (Button) view.findViewById(R.id.elecctromag);
        Button supp = (Button) view.findViewById(R.id.supp);

        mechanics.setOnClickListener(this);
        waves.setOnClickListener(this);
        mattermatt2.setOnClickListener(this);
        electromag.setOnClickListener(this);
        supp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mechanics:
                Toast.makeText(getContext(), "Opening  Mechanics", Toast.LENGTH_SHORT).show();
                changeFragment(new MechanicsFragment());
                break;
            case R.id.matter2:
                Toast.makeText(getContext(), "Opening  Mechanics", Toast.LENGTH_SHORT).show();
                changeFragment(new MatterMatt2Fragment());
                break;
            case R.id.waves:
                Toast.makeText(getContext(), "Opening  Waves", Toast.LENGTH_SHORT).show();
                changeFragment(new SWLFragment());
                break;
            case R.id.elecctromag:
                Toast.makeText(getContext(), "Opening  Electronics & magnetism", Toast.LENGTH_SHORT).show();
             //   changeFragment(new E );
                break;
            case R.id.supp:
                Toast.makeText(getContext(), "Opening  Supplementary", Toast.LENGTH_SHORT).show();
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
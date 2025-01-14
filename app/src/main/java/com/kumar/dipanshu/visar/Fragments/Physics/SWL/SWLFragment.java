package com.kumar.dipanshu.visar.Fragments.Physics.SWL;

import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kumar.dipanshu.visar.Fragments.Physics.SWL.Lights.LightFragment;
import com.kumar.dipanshu.visar.Fragments.Physics.SWL.Sound.LabSoundFragment;
import com.kumar.dipanshu.visar.Fragments.Physics.SWL.Sound.SoundFragment;
import com.kumar.dipanshu.visar.Fragments.Physics.SWL.Waves.LabWavesFragment;
import com.kumar.dipanshu.visar.Fragments.Physics.SWL.Waves.WavesFragment;
import com.kumar.dipanshu.visar.R;

public class SWLFragment  extends Fragment {
    private View parentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView= inflater.inflate(R.layout.fragment_s_w_l,container,false);
        Button syllabus = parentView.findViewById(R.id.Syllabus);
        Button ar = (Button) parentView.findViewById(R.id.ar);

        Button sound= (Button) parentView.findViewById(R.id.sound);
        Button waves= (Button) parentView.findViewById(R.id.waves);
        Button light = (Button) parentView.findViewById(R.id.light);
        Button supp = (Button) parentView.findViewById(R.id.supp);
//        Button unit6 = (Button) parentView.findViewById(R.id.UNIT_6);

        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new SoundFragment());

            }
        });

        waves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new WavesFragment());
            }
        });

        light.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new LightFragment());
            }
        });
/*
        unit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new WalkThroughForce());
            }
        });

        unit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new MunchForce());
            }

        });

        unit6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new LabForce());
            }
        });*/
        return parentView;

    }

    private void changeFragment(Fragment targetFragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentPage, targetFragment, "fragment")
                .addToBackStack(null)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}

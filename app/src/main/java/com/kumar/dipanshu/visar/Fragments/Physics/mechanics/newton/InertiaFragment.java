package com.kumar.dipanshu.visar.Fragments.Physics.mechanics.newton;

import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kumar.dipanshu.visar.R;


public class InertiaFragment extends Fragment {
    private View parentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView= inflater.inflate(R.layout.fragment_inertia,container,false);
        Button syllabus = parentView.findViewById(R.id.Syllabus);
        Button ar = (Button) parentView.findViewById(R.id.ar);
        Button xplore3d = (Button) parentView.findViewById(R.id.xplore3D);
        Button lab = (Button) parentView.findViewById(R.id.lab);
        Button vr = (Button) parentView.findViewById(R.id.vr);
        Button supp = (Button) parentView.findViewById(R.id.supp);
//        Button unit6 = (Button) parentView.findViewById(R.id.UNIT_6);


        xplore3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new Inertia3DFragment());

            }
        });
        lab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new LabInertiaFragment());

            }
        });

        /*unit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new DemoForce());
            }
        });

        unit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new HelpForce());
            }
        });

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

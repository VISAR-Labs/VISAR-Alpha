package com.kumar.dipanshu.visar.Fragments.mechanics;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kumar.dipanshu.visar.R;


public class ForceFragment extends Fragment {
    private View parentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView= inflater.inflate(R.layout.fragment_force,container,false);
        Button syllabus = parentView.findViewById(R.id.Syllabus);
        Button unit1 = (Button) parentView.findViewById(R.id.UNIT_1);

        Button unit2 = (Button) parentView.findViewById(R.id.UNIT_2);
        Button unit3 = (Button) parentView.findViewById(R.id.UNIT_3);
        Button unit4 = (Button) parentView.findViewById(R.id.UNIT_4);
        Button unit5 = (Button) parentView.findViewById(R.id.UNIT_5);
        Button unit6 = (Button) parentView.findViewById(R.id.UNIT_6);

        unit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new XploreForceFragment());

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

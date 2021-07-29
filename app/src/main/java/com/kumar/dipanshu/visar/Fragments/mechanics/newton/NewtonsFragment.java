package com.kumar.dipanshu.visar.Fragments.mechanics.newton;

import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kumar.dipanshu.visar.R;



public class NewtonsFragment extends Fragment {

    private View parentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView= inflater.inflate(R.layout.fragment_newtons,container,false);
        Button syllabus = parentView.findViewById(R.id.Syllabus);
        Button ar = (Button) parentView.findViewById(R.id.ar);

        Button inertia = (Button) parentView.findViewById(R.id.inertia);
        Button motion= (Button) parentView.findViewById(R.id.motion);
        Button gravity = (Button) parentView.findViewById(R.id.gravity);
        Button acceleration= (Button) parentView.findViewById(R.id.acceleration);
//        Button help = (Button) parentView.findViewById(R.id.help);

        inertia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new InertiaFragment());

            }
        });

       motion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new MotionFragment());
            }
        });

        gravity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new GravityFragment());
            }
        });

        acceleration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new AccelerationFragment());
            }
        });

      /*  help.setOnClickListener(new View.OnClickListener() {
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

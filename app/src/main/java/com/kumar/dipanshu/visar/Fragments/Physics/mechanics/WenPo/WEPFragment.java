package com.kumar.dipanshu.visar.Fragments.Physics.mechanics.WenPo;

import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.kumar.dipanshu.visar.Fragments.Physics.mechanics.newton.AccelerationFragment;
import com.kumar.dipanshu.visar.Fragments.Physics.mechanics.newton.GravityFragment;
import com.kumar.dipanshu.visar.Fragments.Physics.mechanics.newton.InertiaFragment;
import com.kumar.dipanshu.visar.Fragments.Physics.mechanics.newton.MotionFragment;
import com.kumar.dipanshu.visar.R;


public class WEPFragment extends Fragment {



    public WEPFragment() {
        // Required empty public constructorK
    }

    private View parentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        parentView= inflater.inflate(R.layout.fragment_w_e_p,container,false);
        Button syllabus = parentView.findViewById(R.id.Syllabus);
        Button work = (Button) parentView.findViewById(R.id.work);

        Button energy = (Button) parentView.findViewById(R.id.energy);
        Button power= (Button) parentView.findViewById(R.id.power);
       // Button gravity = (Button) parentView.findViewById(R.id.gravity);
       // Button acceleration= (Button) parentView.findViewById(R.id.acceleration);
//        Button help = (Button) parentView.findViewById(R.id.help);

        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new WorkFragment());

            }
        });

        energy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new EnergyFragment());
            }
        });

        power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new PowerFragment());
            }
        });

       /*  acceleration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(new AccelerationFragment());
            }
        });

       help.setOnClickListener(new View.OnClickListener() {
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

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

public class SecondMenuFragment extends Fragment implements View.OnClickListener {

    public SecondMenuFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second_menu, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button matter = (Button) view.findViewById(R.id.matter1);
        Button chemchange = (Button) view.findViewById(R.id.chemChange);
        Button chemSys = view.findViewById(R.id.chemSys);
        Button supp = view.findViewById(R.id.supp);
        matter.setOnClickListener(this);
        chemchange.setOnClickListener(this);
        chemSys.setOnClickListener(this);
        supp.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.matter1:
                Toast.makeText(getContext(), "Opening matter and Matterial 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chemChange:
                Toast.makeText(getContext(), "Opening Chemical Change", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chemSys:
                Toast.makeText(getContext(), "Opening Chemical Systems", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
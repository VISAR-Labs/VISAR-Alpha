package com.kumar.dipanshu.visar.Fragments.Physics.mechanics.newton;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kumar.dipanshu.visar.R;
import com.kumar.dipanshu.visar.gridlayoutmanager.AutoFitGridLayoutManager;
import com.kumar.dipanshu.visar.gridlayoutmanager.RecyclerViewAdapter;
import com.kumar.dipanshu.visar.model.DataModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewtonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewtonFragment extends Fragment implements RecyclerViewAdapter.ItemListener{
    RecyclerView recyclerView;
    ArrayList<DataModel> arrayList;
    private View parentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //  setHasOptionsMenu(true);
        parentView = inflater.inflate(R.layout.fragment_newton, container, false);
        recyclerView = (RecyclerView) parentView.findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.HORIZONTAL));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        initView();
        return parentView;
    }

    private void initView() {


        arrayList=new ArrayList<>();
        arrayList.add(new DataModel("1st Law (Motion)", R.drawable.beer));
        arrayList.add(new DataModel("2nd Law (Inertia)", R.drawable.ferrari));
        arrayList.add(new DataModel("3rd Law(Acceleration)", R.drawable.jetpack_joyride));
        arrayList.add(new DataModel("4th Law Gravity", R.drawable.three_d));
        //arrayList.add(new DataModel("Mass and Weight", R.drawable.terraria));
        //arrayList.add(new DataModel("4th Law Gravity", R.drawable.three_d));
        //arrayList.add(new DataModel("Mass & Weight", R.drawable.terraria));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(),arrayList, this);
        recyclerView.setAdapter(adapter);

        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(getActivity(), 900000);
        recyclerView.setLayoutManager(layoutManager);


        /**
         Simple GridLayoutManager that spans two columns
         **/
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }
    @Override
    public void onStart(){
        super.onStart();
        // Toastを表示
        ;	// getActivityでmainActivityを取得.
        Toast.makeText(getActivity(), "onStart()", Toast.LENGTH_LONG).show();	// Toast.makeText.showで"onStart()"を表示.
    }

    // フラグメントの復帰時
    @Override
    public void onResume(){
        super.onResume();
        // Toastを表示
        // getActivityでmainActivityを取得.
        Toast.makeText(getActivity(), "onResume()", Toast.LENGTH_LONG).show();	// Toast.makeText.showで"onResume()"を表示.
        // countを増やす.
        Toast.makeText(getActivity(), "count = " , Toast.LENGTH_LONG).show();	// Toast.makeText.showでcountを表示.
    }

    // フラグメントの一時停止時
    @Override
    public void onPause(){
        super.onPause();
        // Toastを表示

        Toast.makeText(getActivity(), "onPause()", Toast.LENGTH_LONG).show();	// Toast.makeText.showで"onPause()"を表示.
    }

    // フラグメントの停止時
    @Override
    public void onStop(){
        super.onStop();
        // Toastを表示

        Toast.makeText(getActivity(), "onStop()", Toast.LENGTH_LONG).show();	// Toast.makeText.showで"onStop()"を表示.
    }

    // フラグメントのビュー破棄時

    @Override
    public void onDestroyView() {
        // Toastを表示
        // getActivityでmainActivityを取得.
        Toast.makeText(getActivity(), "onDestroyView()", Toast.LENGTH_LONG).show();	// Toast.makeText.showで"onDestroyView()"を表示.
        super.onDestroyView();
    }

    // フラグメントの破棄時
    @Override
    public void onDestroy(){
        // Toastを表示
        // getActivity();	// getActivityでmainActivityを取得.
        Toast.makeText(getActivity(), "onDestroy()", Toast.LENGTH_LONG).show();	// Toast.makeText.showで"onDestroy()"を表示.
        super.onDestroy();
    }

    @Override
    public void onItemClick(DataModel item) {
        //   Toast.makeText(getContext(), " Opening Module " + item.text  , Toast.LENGTH_SHORT).show();
        if(item.text.equalsIgnoreCase("1st Law (Motion)")){
            Toast.makeText(getContext(), " Opening Module " + item.text  , Toast.LENGTH_SHORT).show();
            changeFragment(new ForceFragment());}
        else if(item.text.equalsIgnoreCase("2nd Law Inertia")){
            Toast.makeText(getContext(), " Opening Module " + item.text  , Toast.LENGTH_SHORT).show();
            changeFragment(new InertiaFragment());
        }
        else if(item.text.equalsIgnoreCase("3rd Law Acceleration")){
            Toast.makeText(getContext(), " Opening Module " + item.text  , Toast.LENGTH_SHORT).show();
            changeFragment(new AccelerationFragment());
        }
        else if(item.text.equalsIgnoreCase("4th Law Gravity")){
            Toast.makeText(getContext(), " Opening Module " + item.text  , Toast.LENGTH_SHORT).show();
            changeFragment(new GravityFragment());
        }
      /* else if(item.text.equalsIgnoreCase("Mass & Weight")){
            Toast.makeText(getContext(), " Opening Module " + item.text  , Toast.LENGTH_SHORT).show();
            changeFragment(new MassFragment());
        }*/
    }

    private void changeFragment(Fragment targetFragment) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentPage, targetFragment, "fragment")
                .addToBackStack(this.toString())
                //.addToBackStack(null)
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}

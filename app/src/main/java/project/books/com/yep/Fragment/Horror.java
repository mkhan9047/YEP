package project.books.com.yep.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import project.books.com.yep.Adapter.CatagoryListAdapter;
import project.books.com.yep.Pojo.NavigationListPojo;
import project.books.com.yep.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Horror extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    CatagoryListAdapter adapter;


    public Horror() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_horror, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        List<NavigationListPojo> list = new ArrayList<>();

        list.add(new NavigationListPojo(R.mipmap.american,"American"));
        list.add(new NavigationListPojo(R.mipmap.monster,"Monster"));
        list.add(new NavigationListPojo(R.mipmap.scary,"Scary"));
        list.add(new NavigationListPojo(R.mipmap.paranormal,"Paranormal"));
        list.add(new NavigationListPojo(R.mipmap.halloen,"Halloen"));
        list.add(new NavigationListPojo(R.mipmap.vampire,"Vampire"));

        recyclerView = getView().findViewById(R.id.horror_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CatagoryListAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}

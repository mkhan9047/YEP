package project.books.com.yep.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import project.books.com.yep.Pojo.FragmentPopulatePojo;
import project.books.com.yep.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment {

ImageView mainImage;
    public PagerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pager, container, false);
    }


    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getView()!=null){
            mainImage = getView().findViewById(R.id.fragment_image);
            final FragmentPopulatePojo populatePojo = (FragmentPopulatePojo) getArguments().getSerializable("data");
            assert populatePojo != null;
            mainImage.setImageResource(populatePojo.getImage());

            mainImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getActivity(),populatePojo.getTitle()+" Clicked",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

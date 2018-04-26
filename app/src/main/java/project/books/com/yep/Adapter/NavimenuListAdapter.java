package project.books.com.yep.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import project.books.com.yep.Pojo.NavigationListPojo;
import project.books.com.yep.R;

/**
 * Created by Mujahid on 4/26/2018.
 */

public class NavimenuListAdapter extends ArrayAdapter<NavigationListPojo> {

    private Context context;
    private int res;
    private List<NavigationListPojo> list;

    private CircleImageView imageView;
    private TextView title;
    public NavimenuListAdapter(@NonNull Context context, int resource, List<NavigationListPojo> list) {
        super(context, resource, list);
        this.context = context;
        res = resource;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LinearLayout NaviView;
        final NavigationListPojo pojo = list.get(position);
        if (convertView == null) {
            NaviView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(inflater);
            assert layoutInflater != null;
            layoutInflater.inflate(res, NaviView, true);

        } else {

            NaviView = (LinearLayout) convertView;


        }

        title = NaviView.findViewById(R.id.navi_list_text);
        imageView = NaviView.findViewById(R.id.navi_list_icon);

        title.setText(pojo.getTitle());
        imageView.setImageResource(pojo.getImage());

        return  NaviView;
    }


}

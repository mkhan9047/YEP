package project.books.com.yep.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project.books.com.yep.Pojo.NavigationListPojo;
import project.books.com.yep.R;

/**
 * Created by Mujahid on 5/9/2018.
 */

public class CatagoryListAdapter extends RecyclerView.Adapter<CatagoryListAdapter.MyViewHolder> {

    private List<NavigationListPojo> list = new ArrayList<>();

    public CatagoryListAdapter(List<NavigationListPojo> list) {
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.catagory_list_custom, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getTitle());
        holder.imageView.setImageResource(list.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.catagory_list_image);
            textView = itemView.findViewById(R.id.catagory_list_text);
        }
    }
}

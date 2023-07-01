package sg.edu.np.mad.practical3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sg.edu.np.mad.practical3.MyObject;
import sg.edu.np.mad.practical3.R;
import sg.edu.np.mad.practical3.customViewHolder;

public class customAdapter extends RecyclerView.Adapter<customViewHolder> {
    private ArrayList<MyObject> list_object;
    private OnItemClickListener itemClickListener;
    public interface OnItemClickListener {
        void onItemClick(MyObject object);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        itemClickListener = listener;
    }
    public customAdapter(ArrayList<MyObject>input){
        list_object=input;
    }
    public customViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        if (viewType==0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout, parent, false);
            customViewHolder holder = new customViewHolder(view);
            return holder;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout, parent, false);
        customViewHolder holder = new customViewHolder(view);
        return holder;

    }
    public void onBindViewHolder(customViewHolder holder, int position){
        MyObject obj=list_object.get(position);
        holder.header.setText(obj.getHeader());
        holder.desc.setText(obj.getDesc());
        holder.image.setImageResource(obj.getMyImageView());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the onItemClick method of the listener when the card is clicked

                if (itemClickListener != null) {
                    itemClickListener.onItemClick(obj);
                    Log.v("Hi","Hi");
                }
            }
        });


    }

    public int getItemCount(){
        return list_object.size();
    }
}

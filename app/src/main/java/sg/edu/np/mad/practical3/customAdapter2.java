package sg.edu.np.mad.practical3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customAdapter2 extends RecyclerView.Adapter<customViewholder2>
{
    private ArrayList<MyObject> list_object;
    private customAdapter.OnItemClickListener itemClickListener;
    public interface OnItemClickListener {
        void onItemClick(MyObject object);
    }

    public void setOnItemClickListener(customAdapter.OnItemClickListener listener) {
        itemClickListener = listener;
    }
    public customAdapter2(ArrayList<MyObject>input){
        list_object=input;
    }
    public customViewholder2 onCreateViewHolder(ViewGroup parent, int viewType){
        if (viewType==0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slicelayout, parent, false);
            customViewholder2 holder = new customViewholder2(view);
            return holder;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slicelayout, parent, false);
        customViewholder2 holder = new customViewholder2(view);
        return holder;

    }

    public void onBindViewHolder(customViewholder2 holder, int position){
        MyObject obj=list_object.get(position);;
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


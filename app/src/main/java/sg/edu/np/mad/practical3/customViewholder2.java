package sg.edu.np.mad.practical3;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class customViewholder2 extends RecyclerView.ViewHolder {
    public ImageView image;
    public customViewholder2(View itemView){
        super(itemView);
        image =itemView.findViewById(R.id.imageView2);
    }
}

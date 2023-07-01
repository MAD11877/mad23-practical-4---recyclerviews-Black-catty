package sg.edu.np.mad.practical3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class customViewHolder extends RecyclerView.ViewHolder {
    public TextView header;
    TextView desc;
    public ImageView image;
    public customViewHolder(View itemView){
        super(itemView);
        header=itemView.findViewById(R.id.textView2);
        desc=itemView.findViewById(R.id.textView3);
        image=itemView.findViewById(R.id.imageView);

    }
}

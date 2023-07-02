package sg.edu.np.mad.practical3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class customViewholder2 extends RecyclerView.ViewHolder {
    ImageView imageViewProfile;
    TextView textViewName;
    TextView textViewDescription;

    public customViewholder2(@NonNull View itemView) {
        super(itemView);
        imageViewProfile = itemView.findViewById(R.id.imageViewProfile);
        textViewName = itemView.findViewById(R.id.textViewName);
        textViewDescription = itemView.findViewById(R.id.textViewDescription);

        // Set click listener for the profile image

    }
}

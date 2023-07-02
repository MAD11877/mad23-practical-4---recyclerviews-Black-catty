package sg.edu.np.mad.practical3;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    final String TITLE ="List Activity";
    String UserNumber;

    String UserDescription;
    ArrayList<User> UserList = new ArrayList<User>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        createRandomUsers(UserList);


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        customAdapter myAdapter = new customAdapter(UserList);

        LinearLayoutManager mLayoutmanager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutmanager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);


        myAdapter.setOnItemClickListener(new customAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int position) {

                User Me = UserList.get(position);
                queryOTP(Me);
            }
        });
    }



    private void queryOTP(User user) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Profile");
        builder.setMessage(user.name);
        builder.setCancelable(false);
        builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Intent myIntent = new Intent(ListActivity.this, MainActivity.class);
                myIntent.putExtra("myNumber", user.name);
                myIntent.putExtra("myNumber2",user.description);
                myIntent.putExtra("ID",user.id);
                myIntent.putExtra("Followed",user.followed);
                startActivity(myIntent);
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                onRestart();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private int generatedOTP() {
        Random ran = new Random();
        int myNumber = ran.nextInt(999999999);
        return myNumber;
    }

    private boolean generateBool() {
        Random rand = new Random();
        boolean Truth = rand.nextBoolean();
        return Truth;
    }

    private void createRandomUsers(ArrayList<User> UList) {
        for (int i = 0; i <= 20; i++) {
            Integer Number = generatedOTP();
            String Username = "Name-" + Number;
            String Description = "Description " + generatedOTP();
            Integer Id = Number;
            Boolean Follows = generateBool();
            User RU = new User(Username, Description, Id, Follows);
            UList.add(RU);
        }

    }

    public User FindUser(ArrayList<User> Ulist, String cV) {
        for (int i = 0; i < 20; i++) {
            if (Ulist.get(i).name == cV) {
                return Ulist.get(i);
            }

        }return null;
    }
    public char FindLastcharacter(String s)
    {
        int length=s.length();
        char Last=s.charAt(length-1);
        return Last;
    }


}
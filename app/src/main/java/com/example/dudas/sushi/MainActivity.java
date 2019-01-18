package com.example.dudas.sushi;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ListView;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Profile> list;
    MyAdapter adapter;
    String p;

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDrawerLayout = findViewById(R.id.drawer_layout);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);


        recyclerView = (RecyclerView) findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<Profile>();


        reference = FirebaseDatabase.getInstance().getReference().child("sushi");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

               for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                //  Sushi sushi = dataSnapshot.getValue();
                  //  list.add(sushi)
                     Profile p = dataSnapshot1.getValue(Profile.class);
                    list.add(p);
                   // collectPhoneNumbers((Map<String, Object>) dataSnapshot.getValue());

                    // }
                    adapter = new MyAdapter(MainActivity.this, list);
                    recyclerView.setAdapter(adapter);
                }

        /*
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Profile p = dataSnapshot1.getValue(Profile.class);
                    list.add(p);
                    collectPhoneNumbers((Map<String,Object>) dataSnapshot.getValue());
                } */
             //   Log.d("Produkty1111",list+"");
                adapter = new MyAdapter(MainActivity.this,list);
                recyclerView.setAdapter(adapter);

            }



         /*   private void collectPhoneNumbers(Map<String,Object>   sushi) {

                ArrayList<String> phoneNumbers = new ArrayList<>();

                //iterate through each user, ignoring their UID
                for (Map.Entry<String, Object> entry : sushi.entrySet()){

                    //Get user map
                    Map singleUser = (Map) entry.getValue();
<<<<<<< HEAD
                    //Get phone field and append to list
                    phoneNumbers.add((String) singleUser.get("nazwa"));

=======
                    //String nazwa = entry.getValue("nazwa");
                    //Get phone field and append to list
                    phoneNumbers.add((Long) singleUser.get("nazwa"));

                }

                System.out.println(phoneNumbers.toString());
            } */
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Someting is wrong", Toast.LENGTH_SHORT).show();
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });

    }


}


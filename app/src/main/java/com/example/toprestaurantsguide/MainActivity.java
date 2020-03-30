package com.example.toprestaurantsguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.LinearGradient;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //array objects are in the strings xml file
    //initialise the string arrays
    String s1 [];
    String s2 [];
    String s3 [];
    String s4 [];
    //image array
    //this is int[] and not a string[] as you can pass in any number of int[]objects (arguments) e.g the imported images
    //R.drawable to initialise images in the array based on the file name in the same order as the string restaurant name array
    int images[] = {R.drawable.barzaari, R.drawable.hotpot, R.drawable.ippudo, R.drawable.kittyhawk, R.drawable.vapiano, R.drawable.fujiyama, R.drawable.spiceworld, R.drawable.gami, R.drawable.donpepp, R.drawable.burger};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //add recycler view object and initialising the object through the recyclerView id
        recyclerView = findViewById(R.id.recyclerView);

        //store string array in the variable s1,s2,s3,s4 respectively
        s1 = getResources().getStringArray(R.array.restaurant_name);
        s2 = getResources().getStringArray(R.array.location);
        s3 = getResources().getStringArray(R.array.cuisine);
        s4 = getResources().getStringArray(R.array.rating);

        //initialise the class in from the adapter and pass all the paramaters
        //context is main activity (this)
        //pass the values from the arrays in main activity to the myadapater class
        MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3, s4, images);
        //set Adapater on the onCreateMethod
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}

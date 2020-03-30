package com.example.toprestaurantsguide;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

public class RestaurantDetails extends AppCompatActivity {
//need to create a second activity for the 2nd page when user clicks on the recycler view rows
    //the 2nd page will show the same image as the recycler view but larger

    //create object or image view
    ImageView mainImage;

    //create the image variable
    int myImages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        //
        mainImage= findViewById(R.id.bigrestaurantimage);

        //initialise the methods
        getData();
        setData();
    }
//2 methods
    //gettng the data passed in the intent
    private void getData(){
        //if block to check if data exists in the intent object
      if (getIntent().hasExtra("myImages")){
          //store the data from the intent in the created variable
          myImages = getIntent().getIntExtra("myImages", 1); //random number

      }else{ //if doesnt exist, show a message saying there is no image
          Toast.makeText(this,"No image", Toast.LENGTH_SHORT).show();
      }


    }
    //set data to the imageview
    private void setData(){
        mainImage.setImageResource(myImages); //set the data of the image

    }
}

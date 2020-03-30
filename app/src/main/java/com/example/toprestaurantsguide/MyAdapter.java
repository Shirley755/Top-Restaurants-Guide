package com.example.toprestaurantsguide;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


//recycler View Adapter --> creates views for items and replaces the content of he vies with the created data items
//Adapter is the bridge between the UI and the data (overall holds the data and shows it through the recyclerview)
//pass in the paramater myViewHolder which is the inner class inside the overall main adapter
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
//this auto implemented methods on my adapter

    //variables to hold the values which is passed from the main activity
    String data1[];
    String data2[];
    String data3[];
    String data4[];
    int images[];
    Context context;

//constructor to initalise the created object, and pass in the parameters
    public MyAdapter(Context ct, String s1[], String s2[], String s3[], String s4[], int imgs[]){
        //store the values inside the constructor from the previously created variables
        context =ct;
        data1 =s1;
        data2=s2;
        data3=s3;
        data4=s4;
        images=imgs;

    }
    @NonNull
    @Override

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create layout inflater object
        //inflate the recyclerview_layout file
        LayoutInflater inflater = LayoutInflater.from(context);
        //store inflator inside view to return view
        View view =inflater.inflate(R.layout.recyclerview_layout,parent, false); //to match constructor paramters
        return new MyViewHolder(view); //connectedto myViewHolder class below
        //pass view inside myViewHolder class
    }

    @Override
    //myViewHolder is communicating with this as determined from the parameter
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        //holder to dynamically set the text
    holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myText3.setText(data3[position]);
        holder.myText4.setText(data4[position]);
        holder.myImages.setImageResource(images[position]);
        //holder object to find constraint layout and set onclick listener
        holder.mainactiviy.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //create intent object and pass context and the 2nd activity class
                Intent intent = new Intent(context,RestaurantDetails.class);
                //pass image value to the intent object
                intent.putExtra("myImages", images[position]);
                context.startActivity(intent); //context object to use start activity method and then pass in the intent
            }
        });
    }

    @Override
    //pass the number of items in the array use the length method on either data1, data2 or images
    public int getItemCount() {
        return images.length;
    }

//inner class
    public class MyViewHolder extends RecyclerView.ViewHolder {
//create objects for the UI
        TextView myText1;
        TextView myText2;
        TextView myText3;
        TextView myText4;
        ImageView myImages;
        ConstraintLayout mainactiviy;

// auto implemented constructors
    //receive the view from above
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //find the ID for the objects
            myText1 = itemView.findViewById(R.id.name);
            myText2 = itemView.findViewById(R.id.location);
            myText3 = itemView.findViewById(R.id.cuisine);
            myText4 = itemView.findViewById(R.id.rating);
            myImages = itemView.findViewById(R.id.imagerestaurant);
            mainactiviy = itemView.findViewById(R.id.mainactivity);
        }
    }
}
//created a new layout resource file )recyclerview_layout to represent the rows in the recyclerview
    //added the card view to give more of a list effect
    //constrained the restaurant image, name, cuisine type, location and rating
    //styled the UI through bold fonts and colours
    //wrap content height to ensure there is multiple rows

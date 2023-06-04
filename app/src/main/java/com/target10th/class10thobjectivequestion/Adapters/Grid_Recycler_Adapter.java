package com.target10th.class10thobjectivequestion.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.target10th.class10thobjectivequestion.MainActivity2;
import com.target10th.class10thobjectivequestion.Models.Grid_Recycler_Model;
import com.target10th.class10thobjectivequestion.R;

import java.util.ArrayList;

public class Grid_Recycler_Adapter extends RecyclerView.Adapter<Grid_Recycler_Adapter.MyViewHolder> {


    ArrayList<Grid_Recycler_Model> models;
    Context context;

    public Grid_Recycler_Adapter(ArrayList<Grid_Recycler_Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.grid_card,parent,false);
       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Grid_Recycler_Model model = models.get(position);

     holder.textView.setText(model.getBookName());
     Glide.with(holder.imageView).load(model.getImgUrl()).into(holder.imageView);
     holder.cardView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
           //  Toast.makeText(context, model.getDB(), Toast.LENGTH_SHORT).show();

             Intent intent = new Intent(context, MainActivity2.class);
             intent.putExtra("db",model.getDB());
             intent.putExtra("title",model.getBookName());
             context.startActivity(intent);

         }
     });


    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.Card_click);
            textView = itemView.findViewById(R.id.bookName);
            imageView = itemView.findViewById(R.id.bookImage);


        }
    }
}

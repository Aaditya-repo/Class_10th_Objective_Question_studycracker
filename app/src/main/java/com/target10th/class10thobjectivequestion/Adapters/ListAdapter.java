package com.target10th.class10thobjectivequestion.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.target10th.class10thobjectivequestion.Models.ListModel;
import com.target10th.class10thobjectivequestion.PDF;
import com.target10th.class10thobjectivequestion.R;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    ArrayList<ListModel> models ;
    Context context;

    CustomTabsIntent customTabsIntent;

    public ListAdapter(ArrayList<ListModel> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ListModel model = models.get(position);

        holder.ChapterNo.setText(model.getChapterNo());
        holder.ChapterName.setText(model.getChapterName());
        holder.viewOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse(model.getViewOnline());

                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                builder.setShowTitle(true);
                builder.setInstantAppsEnabled(true);
                builder.setToolbarColor(ContextCompat.getColor(context,R.color.white));
                customTabsIntent = builder.build();
                customTabsIntent.intent.setPackage("com.android.chrome");
                customTabsIntent.launchUrl(context,uri);

            }
        });

        holder.HdPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Toast.makeText(context, "HD PDF", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, PDF.class);
                intent.putExtra("links",model.getHdPDF());
                intent.putExtra("title",model.getChapterName());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        CardView viewOnline , HdPDF;
        TextView ChapterNo, ChapterName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            viewOnline = itemView.findViewById(R.id.viewOnline);
            HdPDF = itemView.findViewById(R.id.hdpdf);
            ChapterName = itemView.findViewById(R.id.chapterName);
            ChapterNo = itemView.findViewById(R.id.chapterNo);


        }
    }
}

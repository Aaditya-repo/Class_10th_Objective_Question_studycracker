package com.target10th.class10thobjectivequestion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.target10th.class10thobjectivequestion.Adapters.Grid_Recycler_Adapter;
import com.target10th.class10thobjectivequestion.Models.GridModel;
import com.target10th.class10thobjectivequestion.Models.Grid_Recycler_Model;

import java.util.ArrayList;

public class Grid2 extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    RecyclerView gridRecyclerView;
    FirebaseFirestore db;

    ArrayList<Grid_Recycler_Model> models;
    Grid_Recycler_Adapter adapter;
  private String database;
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid2);
        textView = findViewById(R.id.grid_title);
        imageView = findViewById(R.id.grid_back);
        gridRecyclerView = findViewById(R.id.grid_recyclerview);

        textView.setText(getIntent().getStringExtra("title"));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSupportNavigateUp();
            }
        });

        gridRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        db = FirebaseFirestore.getInstance();
        models = new ArrayList<Grid_Recycler_Model>();
        adapter = new Grid_Recycler_Adapter(models,this);
        gridRecyclerView.setAdapter(adapter);
        database = getIntent().getStringExtra("db");
        EventChangeListener();

    }

    private void EventChangeListener() {

        db.collection(database).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {


                if (error != null)
                {
                    return;
                }

                for (DocumentChange dc : value.getDocumentChanges())
                {

                    if (dc.getType() == DocumentChange.Type.ADDED)
                    {

                        models.add(dc.getDocument().toObject(Grid_Recycler_Model.class));

                    }

                }


            }
        });

    }
}
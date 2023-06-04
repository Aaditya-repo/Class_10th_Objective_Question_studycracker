package com.target10th.class10thobjectivequestion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.target10th.class10thobjectivequestion.Adapters.Grid_Recycler_Adapter;
import com.target10th.class10thobjectivequestion.Adapters.ListAdapter;
import com.target10th.class10thobjectivequestion.Models.Grid_Recycler_Model;
import com.target10th.class10thobjectivequestion.Models.ListModel;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ImageView back;
    TextView textView;
    RecyclerView recyclerView;

    FirebaseFirestore db;
    ArrayList<ListModel> models ;
    ListAdapter adapter;
    private String database;
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        back = findViewById(R.id.back_btn1);
        textView = findViewById(R.id.setText1);
        textView.setText(getIntent().getStringExtra("title"));
        recyclerView = findViewById(R.id.recyclerView1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSupportNavigateUp();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        models = new ArrayList<ListModel>();
        adapter = new ListAdapter(models,this);
        recyclerView.setAdapter(adapter);
        database = getIntent().getStringExtra("db");
        EventChangeListner();


    }

    private void EventChangeListner() {

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

                        models.add(dc.getDocument().toObject(ListModel.class));

                    }

                }


            }
        });

    }


}
package com.target10th.class10thobjectivequestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.target10th.class10thobjectivequestion.Adapters.GridAdapter;
import com.target10th.class10thobjectivequestion.Models.GridModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView coursesGV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coursesGV = findViewById(R.id.idGVcourses);

        ArrayList<GridModel> models = new ArrayList<GridModel>();

        models.add(new GridModel("गणित",R.drawable.maths,"hello"));
        models.add(new GridModel("भौतिकी विज्ञान",R.drawable.physics,"hello"));
        models.add(new GridModel("हिंदी",R.drawable.hindi,"/Objective Questions/Hindi/Hindi_Books"));
        models.add(new GridModel("संस्कृत",R.drawable.sanskrit,"/Objective Questions/Sanskrit/Sanskrit_Books"));
        models.add(new GridModel("अंग्रेजी",R.drawable.english,"/Objective Questions/English/English_books"));
        models.add(new GridModel("रसायन विज्ञान",R.drawable.chemistry,"hello"));
        models.add(new GridModel("जीव विज्ञान",R.drawable.biology,"hello"));
        models.add(new GridModel("आपदा प्रबंधन",R.drawable.aapdaprabandhan,"hello"));
        models.add(new GridModel("इतिहास",R.drawable.history,"hello"));
        models.add(new GridModel("अर्थशास्त्र",R.drawable.arthashastra,"hello"));
        models.add(new GridModel("रजनीति विज्ञान",R.drawable.rajniti,"hello"));
        models.add(new GridModel("भूगोल",R.drawable.geography,"hello"));


        GridAdapter gridAdapter = new GridAdapter(this,models);
        coursesGV.setAdapter(gridAdapter);




    }
}
package com.target10th.class10thobjectivequestion.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.target10th.class10thobjectivequestion.Grid2;
import com.target10th.class10thobjectivequestion.MainActivity2;
import com.target10th.class10thobjectivequestion.Models.GridModel;
import com.target10th.class10thobjectivequestion.R;

import java.util.ArrayList;

public class GridAdapter extends ArrayAdapter<GridModel> {


    public GridAdapter(@NonNull Context context, ArrayList<GridModel> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.grid_card, parent, false);
        }

        GridModel courseModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.bookName);
        ImageView courseIV = listitemView.findViewById(R.id.bookImage);
        CardView cardView = listitemView.findViewById(R.id.Card_click);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),Books.class);
                intent.putExtra("title",courseModel.getCourse_name());
                intent.putExtra("db",courseModel.getDb_name());
                getContext().startActivity(intent);*/

                String data = courseModel.getCourse_name();

                if (data == "गणित") {
                    //   Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);



                } else if (data == "भौतिकी विज्ञान") {
                    //  Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);


                } else if (data == "हिंदी") {

                     //Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                  Intent intent = new Intent(getContext(),Grid2.class);
                    intent.putExtra("title",courseModel.getCourse_name());
                    intent.putExtra("db",courseModel.getDb_name());
                    getContext().startActivity(intent);


                } else if (data == "संस्कृत") {

                      Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(getContext(), Grid2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);

                } else if (data == "अंग्रेजी") {

                    // Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), Grid2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);

                }

                else if (data == "रसायन विज्ञान") {

                    //  Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);

                }

                else if (data == "रजनीति विज्ञान") {

                    //  Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);

                }    else if (data == "जीव विज्ञान") {

                    //  Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);

                }    else if (data == "आपदा प्रबंधन") {

                    //  Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);

                }    else if (data == "इतिहास") {

                    //  Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);

                } else if (data == "अर्थशास्त्र") {

                    //  Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);

                }else if (data == "भूगोल") {

                    //  Toast.makeText(getContext(), courseModel.getCourse_name(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(), MainActivity2.class);
                    intent.putExtra("title", courseModel.getCourse_name());
                    intent.putExtra("db", courseModel.getDb_name());
                    getContext().startActivity(intent);

                }

            }
        });

        courseTV.setText(courseModel.getCourse_name());
        courseIV.setImageResource(courseModel.getImgid());
        return listitemView;
    }

}

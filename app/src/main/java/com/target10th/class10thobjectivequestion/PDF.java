package com.target10th.class10thobjectivequestion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.krishna.fileloader.FileLoader;
import com.krishna.fileloader.listener.FileRequestListener;
import com.krishna.fileloader.pojo.FileResponse;
import com.krishna.fileloader.request.FileLoadRequest;

import java.io.File;

public class PDF extends AppCompatActivity {

    private PDFView pdfView;
    private String url;

    TextView textView;

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        pdfView = findViewById(R.id.pdf);
        url = getIntent().getStringExtra("links");
        textView = findViewById(R.id.setText2);
        textView.setText(getIntent().getStringExtra("title"));
        loadFile(url);

    }


    private void loadFile(String url) {
        FileLoader.with(this)
                .load(url)
                .fromDirectory("beta", FileLoader.DIR_EXTERNAL_PRIVATE)
                .asFile(new FileRequestListener<File>() {
                    @Override
                    public void onLoad(FileLoadRequest request, FileResponse<File> response) {

                        File loadedFile = response.getBody();

                        pdfView.fromFile(loadedFile)
                                .password(null)
                                .defaultPage(0)
                                .enableSwipe(true)
                                .swipeHorizontal(false)
                                .enableDoubletap(true)
                                .spacing(2)
                                .scrollHandle(new DefaultScrollHandle(getApplicationContext()))
                                .load();

                    }

                    @Override
                    public void onError(FileLoadRequest request, Throwable t) {
                        Toast.makeText(PDF.this, "Error"+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }



}
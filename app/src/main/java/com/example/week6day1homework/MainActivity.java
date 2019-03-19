package com.example.week6day1homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.week6day1homework.model.datasource.remote.PictureResponse;
import com.example.week6day1homework.model.datasource.remote.PictureResponseCallback;
import com.example.week6day1homework.model.datasource.remote.PictureResponseRepository;
import com.example.week6day1homework.view.adapter.PictureRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements PictureResponseCallback {
RecyclerView rvPhotoList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PictureResponseRepository pictureResponseRepository = new PictureResponseRepository();
        pictureResponseRepository.getPictureResponse("kitten","json","1", this);
    }

    public void Onsuccess(PictureResponse pictureResponse) {
        initializeRecyclerView(pictureResponse);


    }

    private void initializeRecyclerView(PictureResponse pictureResponse)  {

        rvPhotoList = findViewById(R.id.rvPhotoList);
        rvPhotoList.setLayoutManager(new LinearLayoutManager(this));
        rvPhotoList.setAdapter(new PictureRecyclerViewAdapter(pictureResponse));
    }
}

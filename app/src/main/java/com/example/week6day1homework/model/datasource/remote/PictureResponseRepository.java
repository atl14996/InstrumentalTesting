package com.example.week6day1homework.model.datasource.remote;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PictureResponseRepository {
    private RetrofitHelper retrofitHelper;

    public PictureResponseRepository(){

        this.retrofitHelper = new RetrofitHelper();
    }

    public void getPictureResponse(String tag, String format, String jsonCallback, PictureResponseCallback pictureResponseCallback) {


        retrofitHelper.getPictureResponseObservable(tag, format, jsonCallback).subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).subscribe(new PictureResponseObserver(pictureResponseCallback));
    }
}

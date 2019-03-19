package com.example.week6day1homework.model.datasource.remote;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PictureResponseObserver implements Observer<PictureResponse> {
    PictureResponse returnPictureResponse;
    PictureResponseCallback pictureResponseCallback;

    public PictureResponseObserver(PictureResponseCallback pictureResponseCallback) {
        this.pictureResponseCallback = pictureResponseCallback;

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(PictureResponse pictureResponse) {

        returnPictureResponse = pictureResponse;
    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

        pictureResponseCallback.Onsuccess(returnPictureResponse);

    }
}

package com.example.week6day1homework.model.datasource.remote;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.example.week6day1homework.model.datasource.remote.APIConstants.BASE_URL;
import static com.example.week6day1homework.model.datasource.remote.APIConstants.PATH_API;
import static com.example.week6day1homework.model.datasource.remote.APIConstants.QUERY_FORMAT;
import static com.example.week6day1homework.model.datasource.remote.APIConstants.QUERY_JSON_CALLBACK;
import static com.example.week6day1homework.model.datasource.remote.APIConstants.QUERY_TAG;

public class RetrofitHelper {

    private static OkHttpClient getOkhttpClientWithInterceptor() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();


    }
private static Retrofit getRetrofit() {

        return new Retrofit.Builder().baseUrl(BASE_URL).
                client(getOkhttpClientWithInterceptor()).
                addConverterFactory(GsonConverterFactory.
                create()).
    addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
}

private ObservableInterface getPictureResponseInterface() {

        return getRetrofit().create(ObservableInterface.class);

}


public Observable<PictureResponse> getPictureResponseObservable(String tag, String format, String jsonCallback){

       return getPictureResponseInterface().getPictureResponseObservable(tag, format, jsonCallback);

}


public interface ObservableInterface {
        @GET(PATH_API)
    Observable<PictureResponse> getPictureResponseObservable(@Query(QUERY_TAG) String tag,
                                                             @Query(QUERY_FORMAT) String format,
                                                             @Query(QUERY_JSON_CALLBACK) String JsonCallback);

}

}

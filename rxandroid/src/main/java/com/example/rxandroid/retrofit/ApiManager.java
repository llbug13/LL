package com.example.rxandroid.retrofit;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.schedulers.RxThreadFactory;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by LL on 2017/2/9.
 */

public class ApiManager {

    private static final String ENDPOINT = "http://api.openweathermap.org/data/2.5";

    /**
     * 10      * 服务接口
     * 11
     */
    private interface ApiManagerService {
        @GET("/weather")
        public Observable<String> getIpInfo(@Query("ip") String ip);
    }

    public static void get() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
//                .addCallAdapterFactory()
                .build();

        ApiManagerService apiService = retrofit.create(ApiManagerService.class);
        apiService.getIpInfo("63.223.108.42")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}


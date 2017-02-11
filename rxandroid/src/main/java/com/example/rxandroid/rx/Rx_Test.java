package com.example.rxandroid.rx;

import android.util.Log;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by LL on 2017/2/9.
 */

public class Rx_Test {
    private static String tag = "Rx_Test";

    {
//        观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(tag, "onSubscribe: " + d);
            }

            @Override
            public void onNext(String s) {
                Log.d(tag, "Item: " + s);
            }


            @Override
            public void onError(Throwable e) {
                Log.d(tag, "Error!");
            }

            @Override
            public void onComplete() {
                Log.d(tag, "onComplete!");
            }
        };
// Subscriber 继承 Observer ，对Observer类做了扩展
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String s) {
                Log.d(tag, "Item: " + s);
            }


            @Override
            public void onError(Throwable e) {
                Log.d(tag, "Error!");
            }

            @Override
            public void onComplete() {
                Log.d(tag, "Completed!");
            }
        };

//        Observable observable = Observable.create(new Observable().doOnSubscribe().<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("Hello");
//                subscriber.onNext("Hi");
//                subscriber.onNext("Aloha");
//                subscriber.onCompleted();
//            }
//        });
        Observable.just("one", "two", "three", "four", "five")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
//        订阅
        Observable.fromArray(new int[10]);
//        Observable.mergeArray()
//        Observable.create(new ObservableOnSubscribe())
    }
}

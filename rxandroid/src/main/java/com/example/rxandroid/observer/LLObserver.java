package com.example.rxandroid.observer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by LL on 2017/2/8.
 */

public class LLObserver {
    //   被观察
    public static class SimpleObservable extends Observable {
        private int data = 0;

        public int getData() {
            return data;
        }

        public void setData(int i) {
            if (this.data != i) {
                this.data = i;
                setChanged();
            }
            notifyObservers();
            //只有在setChange()被调用后，notifyObservers()才会去调用update()，否则什么都不干。
        }
    }

    //   观察
    public static class SimpleObserver implements Observer {
        public SimpleObserver(SimpleObservable so) {
            so.addObserver(this);
        }

        public void update(Observable o, Object arg/*任意对象，用于传递参数*/) {
            System.out.println("Data has changed to" + ((SimpleObservable) o).getData());
        }
    }

    public static class SimpleTest {
        public static void main(String[] args) {
            SimpleObservable doc = new SimpleObservable();
            SimpleObserver view = new SimpleObserver(doc);
            doc.setData(1);
            doc.setData(2);
            doc.setData(2);
            doc.setData(3);
//            new Thread() {
//                @Override
//                public void run() {
//                    super.run();
//                    for (File folder : folders) {
//                        File[] files = folder.listFiles();
//                        for (File file : files) {
//                            if (file.getName().endsWith(".png")) {
//                                final Bitmap bitmap = context.getBitmapFromFile(file);
//                                getActivity().runOnUiThread(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        imageCollectorView.addImage(bitmap);
//                                    }
//                                });
//                            }
//                        }
//                    }
//                }
//            }.start();
        }

    }


}

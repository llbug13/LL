package com.example.rxandroid.retrofit;

import android.net.Uri;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by LL on 2017/2/9.
 */

public class RE {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            //增加返回值为String的支持
//            .addConverterFactory(ScalarsConverterFactory.create())
            //增加返回值为Gson的支持(以实体类返回)
            .addConverterFactory(GsonConverterFactory.create())
            //增加返回值为Oservable<T>的支持
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build();

    {
        GitHubService service = retrofit.create(GitHubService.class);
        Call<String> call = service.listRepos("");
//        同步请求
        try {
//            这里需要注意的是网络请求一定要在子线程中完成，不能直接在UI线程执行，不然会crash
            String response = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
//                asyncText.setText("异步请求结果: " + response.body().books.get(0).altTitle);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


    }
//    final String MULTIPART_FORM_DATA = "multipart/form-data";
//
//    @NonNull
//    private RequestBody createPartFromString(String descriptionString) {
//        return RequestBody.create(
//                MediaType.parse(MULTIPART_FORM_DATA), descriptionString);
//    }
//
//    @NonNull
//    private MultipartBody.Part prepareFilePart(String partName, Uri fileUri) {
//        File file = FileUtils.getFile(this, fileUri);
//
//        // 为file建立RequestBody实例
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file);
//
//        // MultipartBody.Part借助文件名完成最终的上传
//        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
//    }
//    final String MULTIPART_FORM_DATA = "multipart/form-data";
//
//    @NonNull
//    private RequestBody createPartFromString(String descriptionString) {
//        return RequestBody.create(
//                MediaType.parse(MULTIPART_FORM_DATA), descriptionString);
//    }
//
//    @NonNull
//    private MultipartBody.Part prepareFilePart(String partName, Uri fileUri) {
//        File file = FileUtils.getFile(this, fileUri);
//
//        // 为file建立RequestBody实例
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse(MULTIPART_FORM_DATA), file);
//
//        // MultipartBody.Part借助文件名完成最终的上传
//        return MultipartBody.Part.createFormData(partName, file.getName(), requestFile);
//    }

//String fileUrl = "http://futurestud.io/test.mp4";
//    Call<ResponseBody> call =
//            downloadService.downloadFileWithDynamicUrlSync(fileUrl);
//    call.enqueue(new Callback<ResponseBody>() {
//        @Override
//        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//            Log.d(TAG, "request success");
//        }
//
//        @Override
//        public void onFailure(Call<ResponseBody> call, Throwable t) {
//            if (call.isCanceled()) {
//                Log.e(TAG, "request was cancelled");
//            } else {
//                Log.e(TAG, "other larger issue, i.e. no network connection?");
//            }
//        }
//    });
//}
//
//// 触发某个动作，例如用户点击了取消请求的按钮
//    Call提供了cancel方法可以取消请求，前提是该请求还没有执行
//call.cancel();
//        }
}

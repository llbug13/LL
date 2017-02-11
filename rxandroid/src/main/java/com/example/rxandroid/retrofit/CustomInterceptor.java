package com.example.rxandroid.retrofit;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * Created by LL on 2017/2/9.
 */

public class CustomInterceptor implements Interceptor {
    @Override
    public okhttp3.Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl httpUrl = request.url().newBuilder()
                .addQueryParameter("token", "tokenValue")
                .build();
        request = request.newBuilder().url(httpUrl)
                .header("","'").build();
        return chain.proceed(request);
    }
//    创建完成自定义的Interceptor后，还需要在Retrofit创建client处完成添加
//    addInterceptor(new CustomInterceptor())
//Call<BookSearchResponse> getSearchBooks(@QueryMap Map<String, String> options);
//    假如你需要添加相同Key值，但是value却有多个的情况，一种方式是添加多个@Query参数，还有一种简便的方式是将所有的value放置在列表中，然后在同一个@Query下完成添加，实例代码如下：
//Call<BookSearchResponse> getSearchBooks(@Query("q") List<String> name);


//    @FormUrlEncoded
//    @POST("book/reviews")
//    Call<String> addReviews(@Field("book") String bookId, @Field("title") String title,
//                            @Field("content") String content, @Field("rating") String rating);

//    @FormUrlEncoded将会自动将请求参数的类型调整为application/x-www-form-urlencoded，假如content传递的参数为Good Luck，那么最后得到的请求体就是
//
//            content=Good+Luck
//    FormUrlEncoded不能用于Get请求


//    @Field注解将每一个请求参数都存放至请求体中，还可以添加encoded参数，该参数为boolean型，具体的用法为
//
//    @Field(value = "book", encoded = true) String book
//    1
//            1
//    encoded参数为true的话，key-value-pair将会被编码，即将中文和特殊字符进行编码转换

//    Call<String> addReviews(@FieldMap Map<String, String> fields);

//    @FormUrlEncoded
//    @POST("book/reviews")
//    Call<String> addReviews(@Body Reviews reviews);
//
//    public class Reviews {
//        public String book;
//        public String title;
//        public String content;
//        public String rating;
//    }

//    public interface FileUploadService {
//        // 上传单个文件
//        @Multipart
//        @POST("upload")
//        Call<ResponseBody> uploadFile(
//                @Part("description") RequestBody description,
//                @Part MultipartBody.Part file);
//
//        // 上传多个文件
//        @Multipart
//        @POST("upload")
//        Call<ResponseBody> uploadMultipleFiles(
//                @Part("description") RequestBody description,
//                @Part MultipartBody.Part file1,
//                @Part MultipartBody.Part file2);
//    }

//    @Headers({
//            "Accept: application/vnd.github.v3.full+json",
//            "User-Agent: Retrofit-Sample-App"
//    })

//    @GET("user")
//    Call<User> getUser(@Header("Authorization") String authorization)
}

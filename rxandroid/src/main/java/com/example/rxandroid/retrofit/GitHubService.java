package com.example.rxandroid.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by LL on 2017/2/9.
 */

public interface GitHubService {
    @GET("users/{user}/repos")
//    Call<BookSearchResponse> getSearchBooks(@Query("q") String name,
//                                            @Query("tag") String tag, @Query("start") int start,
//                                            @Query("count") int count);
   public Call<String> listRepos(@Path("user") String user);
}

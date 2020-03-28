package org.example.api;

import org.example.model.Post;
import org.example.model.SendPostResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface ApiService {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/1")
    Call<Post> getPost1();

    @POST("posts")
    Call<SendPostResult> sendPost(@Body Post post);

}

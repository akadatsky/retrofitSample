package org.example;

import org.example.api.ApiManager;
import org.example.api.LambdaCallback;
import org.example.model.Post;
import org.example.model.SendPostResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=================================================");
//        sample1();
//        sample2();
        sample3();
        System.out.println("=================================================");
    }

    private static void sample1() {
        ApiManager.getApiService().getPosts().enqueue(new Callback<List<Post>>() {
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> posts = response.body();
                if (posts != null) {
                    System.out.println("posts.size: " + posts.size());
                }
            }

            public void onFailure(Call<List<Post>> call, Throwable throwable) {
                System.out.println("onFailure: " + throwable);
            }
        });
    }

    private static void sample2() {
        ApiManager.getApiService().getPosts().enqueue(new LambdaCallback<>(
                response -> {
                    List<Post> posts = response.body();
                    if (posts != null) {
                        System.out.println("posts.size: " + posts.size());
                    }
                },
                throwable -> {
                    System.out.println("onFailure: " + throwable);
                }));
    }

    private static void sample3() {
        Post post = new Post(1, 1, "test title", "test body");
        try {
            SendPostResult result = ApiManager.getApiService().sendPost(post).execute().body();
            System.out.println("result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

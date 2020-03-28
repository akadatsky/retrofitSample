package org.example.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LambdaCallback<T> implements Callback<T> {

    public interface SuccessCallback<T> {
        void onResponse(Response<T> response);
    }

    public interface FailureCallback {
        void onFailure(Throwable t);
    }

    private SuccessCallback<T> success;
    private FailureCallback failure;

    public LambdaCallback(SuccessCallback<T> success, FailureCallback failure) {
        this.success = success;
        this.failure = failure;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        success.onResponse(response);
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        failure.onFailure(t);
    }

}

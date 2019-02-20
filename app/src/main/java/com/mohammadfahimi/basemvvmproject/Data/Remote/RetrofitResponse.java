package com.mohammadfahimi.basemvvmproject.Data.Remote;


import android.support.annotation.NonNull;

import com.google.gson.JsonParseException;

import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetrofitResponse<T> implements Callback<T> {

    public enum Errors {ERROR_400, ERROR_401, ERROR_404, ERROR_405, ERROR_500, ERROR_DISCONNECTED, ERROR_PARSE, ERROR_UNKNOWN}

    private Errors error;

    /**
     * Invoked for a received HTTP response.
     * <p>
     * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
     * Call {@link Response#isSuccessful()} to determine if the response indicates success.
     */
    public void onResponse(@NonNull Call<T> call, @NonNull Response<T> response) {
        switch (response.code()) {
            case 400:
                error = Errors.ERROR_400;
                break;
            case 401:
                error = Errors.ERROR_401;
                break;
            case 404:
                error = Errors.ERROR_404;
                break;
            case 405:
                error = Errors.ERROR_405;
                break;
            case 500:
                error = Errors.ERROR_500;
                break;

        }
    }

    /**
     * Invoked when a network exception occurred talking to the server or when an unexpected
     * exception occurred creating the request or processing the response.
     */
    public void onFailure(@NonNull Call<T> call, @NonNull Throwable t) {
        if (t instanceof UnknownHostException)
            error = Errors.ERROR_DISCONNECTED;
        else if (t instanceof JsonParseException)
            error = Errors.ERROR_PARSE;
        else
            error = Errors.ERROR_UNKNOWN;

    }


}

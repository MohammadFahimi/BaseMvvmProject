package com.mohammadfahimi.basemvvmproject.Data.Remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class Resource<T> {
    @NonNull
    public final Status status;
    @Nullable
    public final T data;
    @Nullable
    public final String message;
    @Nullable
    public final RetrofitResponse.Errors error;

    private Resource(@NonNull Status status, @Nullable T data,
                     @Nullable String message, @Nullable RetrofitResponse.Errors error) {
        this.status = status;
        this.data = data;
        this.message = message;
        this.error = error;

    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(Status.SUCCESS, data, null,null);
    }

    public static <T, E> Resource<T> error(String msg, @Nullable T data, RetrofitResponse.Errors error) {
        return new Resource<>(Status.ERROR, data, msg, error);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(Status.LOADING, data, null, null);
    }

    public enum Status {SUCCESS, ERROR, LOADING}

}
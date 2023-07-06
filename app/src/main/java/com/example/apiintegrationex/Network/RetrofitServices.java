package com.example.apiintegrationex.Network;

import com.example.apiintegrationex.Model.ApiPhotos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitServices {

    @GET("/photos")
    Call<List<ApiPhotos>> getAllPhotos();

}

package com.example.apiintegrationex.Presenter;


import android.content.Context;
import android.util.Log;

import com.example.apiintegrationex.Model.ApiPhotos;
import com.example.apiintegrationex.Network.RetrofitClient;
import com.example.apiintegrationex.Network.RetrofitServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosPresenter {

    private View view;
    private Context context;

    public void setView(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public PhotosPresenter(View view) {
        //this.user = new User();
        this.view = view;
    }

    public void getPhotosFromApi(){

        RetrofitServices api = RetrofitClient.getRetrofitInstance().create(RetrofitServices.class);
        Call<List<ApiPhotos>> apiCall = api.getAllPhotos();
        apiCall.enqueue(new Callback<List<ApiPhotos>>() {

            @Override
            public void onResponse(Call<List<ApiPhotos>> call, Response<List<ApiPhotos>> response) {
                Log.d("TAG", "onResponse: Url " + response.raw().request().url());
                try {
                    if(response.isSuccessful()){
                        view.getPhotosData( response.body() );

                    }
                }catch (Exception e){

                }
            }

            @Override
            public void onFailure(Call<List<ApiPhotos>> call, Throwable t) {

            }
        });

    }

    public interface View {
        void getPhotosData(List<ApiPhotos> dataList);
    }
}

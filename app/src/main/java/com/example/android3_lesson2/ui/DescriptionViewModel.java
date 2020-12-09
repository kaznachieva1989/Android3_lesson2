package com.example.android3_lesson2.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3_lesson2.data.models.Film;
import com.example.android3_lesson2.data.network.GhibliService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DescriptionViewModel extends ViewModel {
    MutableLiveData<Film> mutableLiveData = new MutableLiveData<>();

    public void getUserPost(String id) {
        GhibliService.getINSTANCE().getFilm(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                mutableLiveData.setValue(response.body());
                Log.d("mad", "onResponse" + response.body());
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                Log.e("mad", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}

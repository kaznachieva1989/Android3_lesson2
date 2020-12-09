package com.example.android3_lesson2.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3_lesson2.data.models.Film;
import com.example.android3_lesson2.data.network.GhibliService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmViewModel extends ViewModel {
    MutableLiveData<List<Film>> filmMutableLiveData = new MutableLiveData<>();
    MutableLiveData <String> films = new MutableLiveData<>();


    public void getFilms(){
        GhibliService.getINSTANCE().getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                filmMutableLiveData.setValue(response.body());
                Log.d("mall", "getFilms"+ response.body());
            }

            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                    films.setValue("smth wrong!");
                Log.e("mall", "onFailure: " + t.getLocalizedMessage());
            }
        });
    }
}

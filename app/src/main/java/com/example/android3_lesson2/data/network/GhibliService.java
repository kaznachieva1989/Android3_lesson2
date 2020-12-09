package com.example.android3_lesson2.data.network;

import com.example.android3_lesson2.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GhibliService {

    private static final String BASE_URL = "https://ghibliapi.herokuapp.com/";
    private static GhibliService INSTANCE;
    private static GhibliApi ghibliApi;

    public GhibliService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ghibliApi = retrofit.create(GhibliApi.class);
    }

    public static GhibliService getINSTANCE() {
        if (null == INSTANCE) {
            INSTANCE = new GhibliService();
        }
        return INSTANCE;
    }

    public Call<List<Film>> getFilms() {
        return ghibliApi.getFilms();
    }

    public Call<Film> getFilm(String id) {
        return ghibliApi.getFilmById(id);
    }

}

package com.example.android3_lesson2.data.network;

import com.example.android3_lesson2.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GhibliApi {

    @GET("films")
    Call<List<Film>> getFilms();
}

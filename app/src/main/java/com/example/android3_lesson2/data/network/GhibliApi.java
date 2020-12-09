package com.example.android3_lesson2.data.network;

import com.example.android3_lesson2.data.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {

    @GET("films")
    Call<List<Film>> getFilms();

    @GET("films/{filmId}")
    Call<Film> getFilmById(
            @Path("filmId") String filmId
    );
}

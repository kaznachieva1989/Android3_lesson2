package com.example.android3_lesson2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.android3_lesson2.R;
import com.example.android3_lesson2.data.models.Film;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {
    public List<Film> filmList = new ArrayList<>();
    TextView titleFilm, directorFilm, release_date, idFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        titleFilm = findViewById(R.id.titleFilm);
        directorFilm = findViewById(R.id.directorFilm);
        release_date = findViewById(R.id.release_date);
        idFilm = findViewById(R.id.idFilm);

        filmList = getIntent().getParcelableArrayListExtra("filmList");
    }
}
package com.example.android3_lesson2.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.example.android3_lesson2.R;
import com.example.android3_lesson2.data.models.Film;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FilmAdapter.FilmCallBack {

    int position;
    FilmViewModel filmViewModel;
    RecyclerView recyclerView;
    FilmAdapter filmAdapter;
    public List<Film> filmList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmViewModel = ViewModelProviders.of(this).get(FilmViewModel.class);
        filmViewModel.getFilms();
        recyclerView = findViewById(R.id.recycler);
        filmAdapter = new FilmAdapter(filmList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(filmAdapter);

        filmViewModel.filmMutableLiveData.observe(this, new Observer<List<Film>>() {
            @Override
            public void onChanged(List<Film> films) {
                filmAdapter.setList(films);
            }
        });
    }

    @Override
    public void choose(int position) {
       // this.position = position;
//        filmList.get(position);
        Log.d("ololo", "choose");
        Intent intent = new Intent(this, DescriptionActivity.class);
        intent.putExtra("filmList", filmList.get(position));

//        intent.putExtra("id", filmList.get(position).getTitle());
//        intent.putExtra("title", filmList.get(position).getTitle());
//        intent.putExtra("director", filmList.get(position).getDirector());
//        intent.putExtra("release_date", filmList.get(position).getReleaseDate());
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
}
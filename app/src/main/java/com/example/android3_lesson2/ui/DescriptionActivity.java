
package com.example.android3_lesson2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.widget.TextView;
import com.example.android3_lesson2.R;
import com.example.android3_lesson2.data.models.Film;

public class DescriptionActivity extends AppCompatActivity {
    DescriptionViewModel descriptionViewModel;
    String id;

    TextView titleFilm, directorFilm, release_date, idFilm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        initView();
        descriptionViewModel = ViewModelProviders.of(this).get(DescriptionViewModel.class);
        if (getIntent() != null) {
            id = getIntent().getStringExtra("id");
            descriptionViewModel.getUserPost(id);
        }

        descriptionViewModel.mutableLiveData.observe(this, new Observer<Film>() {
            @Override
            public void onChanged(Film film) {
                setData(film);
            }
        });
    }

    public void initView() {
        titleFilm = findViewById(R.id.titleFilm);
        directorFilm = findViewById(R.id.directorFilm);
        release_date = findViewById(R.id.release_date);
        idFilm = findViewById(R.id.idFilm);
    }

    public void setData(Film film) {
        idFilm.setText(film.getId());
        titleFilm.setText(film.getTitle());
        directorFilm.setText(film.getDirector());
        release_date.setText(film.getReleaseDate());
    }
}

package com.example.android3_lesson2.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android3_lesson2.R;
import com.example.android3_lesson2.data.models.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmViewHolder> {

    public List<Film> filmList = new ArrayList<>();
    private FilmCallBack filmCallBack;
    Context context;

    public FilmAdapter(List<Film> filmList, FilmCallBack filmCallBack) {
        this.filmList = filmList;
        this.filmCallBack = filmCallBack;
    }

    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_item, parent, false);
        return new FilmViewHolder(view, filmCallBack);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {
        holder.titleFilm.setText(filmList.get(position).getTitle());
        holder.directorFilm.setText(filmList.get(position).getDirector());
        holder.release_date.setText(filmList.get(position).getReleaseDate());
        holder.idFilm.setText(filmList.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public void setList(List<Film> filmList) {
        this.filmList = filmList;
        notifyDataSetChanged();
    }

    public class FilmViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleFilm, directorFilm, release_date, idFilm;
        private FilmCallBack filmCallBack;

        public FilmViewHolder(@NonNull View itemView, FilmCallBack filmCallBack) {
            super(itemView);
            titleFilm = itemView.findViewById(R.id.titleFilm);
            directorFilm = itemView.findViewById(R.id.directorFilm);
            release_date = itemView.findViewById(R.id.release_date);
            idFilm = itemView.findViewById(R.id.idFilm);

            this.filmCallBack=filmCallBack;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
           filmCallBack.choose(getAdapterPosition());
        }
    }

    interface FilmCallBack {
        void choose(int position);
    }
}

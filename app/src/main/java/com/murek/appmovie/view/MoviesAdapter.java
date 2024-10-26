package com.murek.appmovie.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.murek.appmovie.databinding.ItemMovieBinding;
import com.murek.appmovie.listener.MovieClickedListener;
import com.murek.appmovie.model.Movies;


import java.util.List;


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movies> movies;
    private MovieClickedListener movieClickedListener;
    private Context context;

    public MoviesAdapter(List<Movies> movies, MovieClickedListener movieClickedListener, Context context){
        this.movies = movies;
        this.movieClickedListener = movieClickedListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieBinding binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movies movie = movies.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    //clase interna ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        private final ItemMovieBinding binding;

        public ViewHolder(@NonNull ItemMovieBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

        //metodo para enlazar datos con las vistas
        public void bind(Movies movie){
            binding.movieTitle.setText(movie.getTitle());
            Glide.with(context).load(movie.getCover()).into(binding.movieCover);
            binding.movieRating.setRating(movie.getEstrellas());
            binding.movieCover.setOnClickListener(v -> movieClickedListener.onMovieClicled(movie));
        }
    }
}

package com.murek.appmovie.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.murek.appmovie.model.Movies;

import java.util.ArrayList;
import java.util.List;

public class MoviesViewModel extends ViewModel {

    private MutableLiveData<List<Movies>> movieList;

    public MoviesViewModel(){
        movieList=new MutableLiveData<>();
        loadMovies();
    }

    private void loadMovies(){
        List<Movies> movies = new ArrayList<>();

        movies.add(new Movies("Vacaciones en Familia", "https://via.assets.so/movie.png?id=1&q=95&w=360&h=360&fit=fill", 3.0f));
        movies.add(new Movies("He's all That", "https://via.assets.so/movie.png?id=2&q=95&w=360&h=360&fit=fill", 3.0f));
        movies.add(new Movies("Venom", "https://via.assets.so/movie.png?id=3&q=95&w=360&h=360&fit=fill", 3.0f));
        movies.add(new Movies("Encanto", "https://via.assets.so/movie.png?id=4&q=95&w=360&h=360&fit=fill", 3.0f));
        movies.add(new Movies("Los Locos Adams", "https://via.assets.so/movie.png?id=5&q=95&w=360&h=360&fit=fill", 3.0f));
        movies.add(new Movies("LAMB", "https://via.assets.so/movie.png?id=6&q=95&w=360&h=360&fit=fill", 3.0f));
        movies.add(new Movies("Hose of Gucci", "https://via.assets.so/movie.png?id=7&q=95&w=360&h=360&fit=fill", 3.0f));
        movies.add(new Movies("Red Notice", "https://via.assets.so/movie.png?id=8&q=95&w=360&h=360&fit=fill", 3.0f));
        movies.add(new Movies("Finch", "https://via.assets.so/movie.png?id=9&q=95&w=360&h=360&fit=fill", 3.0f));
        movies.add(new Movies("Moonfall", "https://via.assets.so/movie.png?id=10&q=95&w=360&h=360&fit=fill", 3.0f));
        movieList.setValue(movies);
    }

    public LiveData<List<Movies>> getMovies(){
        return movieList;
    }

}

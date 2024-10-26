package com.murek.appmovie.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.murek.appmovie.databinding.ActivityMainBinding;
import com.murek.appmovie.listener.MovieClickedListener;
import com.murek.appmovie.model.Movies;
import com.murek.appmovie.viewModel.MoviesViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MoviesViewModel moviesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Inicializar el ViewModel con un provider
        moviesViewModel = new ViewModelProvider(this).get(MoviesViewModel.class);
        //Configurar el RecyclerView
        binding.recycler.setLayoutManager(new GridLayoutManager(this, 2));
        //Observar los cambios en la lista de peliculas
        moviesViewModel.getMovies().observe(this, new Observer<List<Movies>>() {
            @Override
            public void onChanged(List<Movies> movies) {
                if(movies != null && !movies.isEmpty()){
                    Log.d("MoviesList", "Mi lista "+ movies.size());

                    //config el adaptador del RecyclerView
                    MoviesAdapter adapter = new MoviesAdapter(movies, new MovieClickedListener() {
                        @Override
                        public void onMovieClicled(Movies movie) {
                            Toast.makeText(MainActivity.this, "Eliges: "+movie.getTitle(), Toast.LENGTH_SHORT).show();
                        }
                    }, MainActivity.this);
                    binding.recycler.setAdapter(adapter);
                } else {
                    Log.d("MoviesList", "Lista vacia");
                }
            }
        });
    }
}
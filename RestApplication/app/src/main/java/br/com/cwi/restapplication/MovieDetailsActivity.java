package br.com.cwi.restapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import br.com.cwi.restapplication.Models.MovieModel;
import br.com.cwi.restapplication.Responses.MovieDetailsResponse;
import br.com.cwi.restapplication.Responses.MovieSearchByNameResponse;
import br.com.cwi.restapplication.Services.MovieService;
import br.com.cwi.restapplication.Services.NetworkService;
import br.com.cwi.restapplication.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by letscode on 25/11/2017.
 */

public class MovieDetailsActivity extends AppCompatActivity implements Callback<MovieDetailsResponse> {

    private TextView tvTitle, tvYear, tvRated, tvReleased, tvRuntime;

    private MovieService movieService;

    private void setUpRetrofit() {
        movieService = NetworkService.getInstance().getMovieService();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.view_details_item);
        initializeComponents();
        MovieModel model = (MovieModel) getIntent().getSerializableExtra(Constants.MOVIE_EXTRA);

        setUpRetrofit();
        callDetailsFromApi(model);
    }

    private void callDetailsFromApi(MovieModel model) {
        movieService.searchMovie(model.getImdbID()).enqueue(this);
    }

    private void setUpDetails(MovieDetailsResponse details) {
        tvTitle.setText(details.getTitle());
        tvYear.setText(details.getYear());
        tvRated.setText(details.getRated());
        tvReleased.setText(details.getReleased());
        tvRuntime.setText(details.getRuntime());
    }

    private void initializeComponents() {
        tvTitle = findViewById(R.id.title_description);
        tvYear = findViewById(R.id.year_description);
        tvRated = findViewById(R.id.rated_description);
        tvReleased = findViewById(R.id.released_description);
        tvRuntime = findViewById(R.id.runtime_description);
    }

    @Override
    public void onResponse(Call<MovieDetailsResponse> call, Response<MovieDetailsResponse> response) {
        if (response.body().getResponse().equalsIgnoreCase("True")) {
            MovieDetailsResponse movieDetailsResponse = response.body();
            setUpDetails(movieDetailsResponse);
        }
    }

    @Override
    public void onFailure(Call<MovieDetailsResponse> call, Throwable t) {
        Log.e("erro", t.getMessage());
    }
}

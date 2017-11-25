package br.com.cwi.restapplication.Services;

import br.com.cwi.restapplication.Responses.MovieDetailsResponse;
import br.com.cwi.restapplication.Responses.MovieSearchByNameResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by juliano.nardon on 25/11/17.
 */

public interface MovieService {

    final String BASE_URL = "/?apikey=77cde810&r=json&plot=short";

    @GET(BASE_URL)
    Call<MovieSearchByNameResponse> searchMovies(@Query("s") String title);

    @GET(BASE_URL)
    Call<MovieDetailsResponse> searchMovie(@Query("i") String imdbId);
}

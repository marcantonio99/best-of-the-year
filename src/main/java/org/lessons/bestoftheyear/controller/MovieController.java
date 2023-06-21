package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String movieList(Model model){
        model.addAttribute("movies", getMoviesString());
        return "movie";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
                movies.add(new Movie(1, "Titolo del film 1"));
                movies.add(new Movie(2, "Titolo del film 2"));
                movies.add(new Movie(3, "Titolo del film 3"));
           return movies;
    }

    private String getMoviesString(){
        List<Movie> movieList = getBestMovies();
        String concat = "";
        for (Movie movie : movieList){
            concat += movie.getTitle();
        }
        return concat.substring(0, concat.length()-2);
    }
}

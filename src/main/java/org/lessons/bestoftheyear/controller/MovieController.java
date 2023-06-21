package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String movieList(Model model, @RequestParam("search") Optional<String> searchString){
        String movieString;
        List<Movie> movieList;
        if (searchString.isPresent()){
            movieString = getMoviesString(searchString.get());
            movieList = getBestMovies(searchString.get());
        }else {
            movieString = getMoviesString();
            movieList = getBestMovies();
        }
        model.addAttribute("movies", movieString);
        model.addAttribute("movieList", movieList);
        return "movies";
    }

    @GetMapping("/list")
    public String redirectList(){
        return "redirect:/movies";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
           movies.add(new Movie(1, "Titolo del film 1"));
           movies.add(new Movie(2, "Titolo del film 2"));
           movies.add(new Movie(3, "Titolo del film 3"));
           return movies;
    }

    private List<Movie> getBestMovies(String search){
        List<Movie> movies = getBestMovies();
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies){
            if (movie.getTitle().toLowerCase().contains(search.toLowerCase())){
                result.add(movie);
            }
        }
        return result;
    }

    private String getMoviesString(){
        List<Movie> movieList = getBestMovies();
        return concatList(movieList);
    }

    private static String concatList(List<Movie> movieList) {
        String concat = "";
        for (Movie movie : movieList){
            concat += movie.getTitle();
        }
        if (concat.length() > 0){
            return concat.substring(0, concat.length() - 2);
        }else return "";
    }

    private String getMoviesString(String search){
        List<Movie> movieList = getBestMovies(search);
        return concatList(movieList);
    }
}

package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/songs")
public class SongController {
    @GetMapping
    public String songList(Model model, @RequestParam("search") Optional<String> searchString){
        String songString;
        List<Song> songList;
        if (searchString.isPresent()){
            songString = getSongsString(searchString.get());
            songList = getBestSongs(searchString.get());
        }else {
            songString = getSongsString();
            songList = getBestSongs();
        }
        model.addAttribute("songs", songString);
        model.addAttribute("songList", songList);
        return "songs";
    }

    @GetMapping("/list")
    public String redirectList(){
        return "redirect:/songs";
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Titolo della canzone 1"));
        songs.add(new Song(2, "Titolo della canzone 2"));
        songs.add(new Song(3, "Titolo della canzone 3"));
        return songs;
    }

    private List<Song> getBestSongs(String search){
        List<Song> songs = getBestSongs();
        List<Song> result = new ArrayList<>();
        for (Song song : songs){
            if (song.getTitle().toLowerCase().contains(search.toLowerCase())){
                result.add(song);
            }
        }
        return result;
    }

    private String getSongsString(){
        List<Song> songList = getBestSongs();
        return concatList(songList);
    }

    private static String concatList(List<Song> songList) {
        String concat = "";
        for (Song song : songList){
            concat += song.getTitle();
        }
        if (concat.length() > 0){
            return concat.substring(0, concat.length() - 2);
        }else return "";
    }

    private String getSongsString(String search){
        List<Song> songList = getBestSongs(search);
        return concatList(songList);
    }
}

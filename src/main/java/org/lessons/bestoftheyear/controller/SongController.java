package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {
    @GetMapping
    public String movieList(Model model){
        model.addAttribute("songs", getSongsString());
        return "song";
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Titolo della canzone 1"));
        songs.add(new Song(2, "Titolo della canzone 2"));
        songs.add(new Song(3, "Titolo della canzone 3"));
        return songs;
    }

    private String getSongsString(){
        List<Song> songList = getBestSongs();
        String concat = "";
        for (Song song : songList){
            concat += song.getTitle();
        }
        return concat.substring(0, concat.length()-2);
    }
}

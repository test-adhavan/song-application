package com.task.song.service;

import com.task.song.entity.Song;
import com.task.song.repository.SongRepository;
import com.task.song.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private SongRepository repository;

    SongService(SongRepository repository){
          this.repository=repository;
    }

    public void addsong(Song song) {

        repository.save(song);

    }

    public List<Song> getallsong() {

        List<Song> songs  = repository.findAll();

        return songs;
    }

    public Song getbyid(Long id) {

        Song song = repository.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));

        return song;

    }

    public void deletebyid(Long id) {

        Song song = repository.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));

        repository.deleteById(id);

    }

    public Song updatebyid(Long id, Song song) {

        Song updatesong = repository.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));

        if(song.getTitle()!=null &&  ! song.getTitle().isBlank()){
            updatesong.setTitle(song.getTitle());
        }
        if(song.getArtist()!=null && !song.getArtist().isBlank()){
            updatesong.setArtist(song.getArtist());
        }
        if(song.getUrl()!=null && !song.getUrl().isBlank()){
            updatesong.setUrl(song.getUrl());
        }
        if(song.getDuration()!=null){
            updatesong.setDuration(song.getDuration());
        }

        return  repository.save(updatesong);




    }

}

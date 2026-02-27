package com.task.song.controller;

import com.task.song.entity.Song;
import com.task.song.service.SongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    private SongService service;

    SongController(SongService service){

        this.service=service;

    }

    @PostMapping("/add")
    public ResponseEntity<String> addsong(@RequestBody Song song){

        service.addsong(song);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Song added sucessfully");


    }

    @GetMapping("/all")
    public ResponseEntity<List<Song>> getallsong(){

       List<Song> songs =  service.getallsong();

       return ResponseEntity.ok(songs);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Song> getbyid(@PathVariable Long id){

        Song song = service.getbyid(id);

        return ResponseEntity.ok(song);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletebyid(@PathVariable Long id){

        service.deletebyid(id);

        return ResponseEntity.ok("delete song sucessfully");

    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updatebyid(@PathVariable Long id , @RequestBody Song song){

     Song updatedsong = service.updatebyid(id,song);

     return ResponseEntity.ok(updatedsong);
    }

}

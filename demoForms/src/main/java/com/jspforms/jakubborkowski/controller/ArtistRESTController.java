package com.jspforms.jakubborkowski.controller;

import com.jspforms.jakubborkowski.model.Artist;
import com.jspforms.jakubborkowski.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/artist")
public class ArtistRESTController{
    private ArtistRepository artistRepository;

    @Autowired
    public void ArtistRestController(ArtistRepository artistRepository) {this.artistRepository = artistRepository;}

    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Artist> findAllArtists() {return artistRepository.findAll();}


    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public ResponseEntity<Artist> deleteArtist (@PathVariable("id") int id) {
        Artist artist = artistRepository.findById(id);
        if (artist == null) {
            System.out.println("Contact not found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        artistRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteArtist (@RequestBody Artist artist) {
        artistRepository.deleteAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<Artist> addArtist(@RequestBody Artist artist){
        artistRepository.save(artist);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}

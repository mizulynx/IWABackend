package com.jspforms.jakubborkowski.controller;

import com.jspforms.jakubborkowski.model.Artist;
import com.jspforms.jakubborkowski.model.Contact;
import com.jspforms.jakubborkowski.model.User;
import com.jspforms.jakubborkowski.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Artist> deleteArtist (@PathVariable("id") long id) {
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



    @RequestMapping(value="/{id}", method = RequestMethod.PATCH)
    //@PatchMapping("/{id}")
    public ResponseEntity<Artist> updatePartOfArtist(@RequestBody Map<String, Object> updates, @PathVariable("id") int id) {
        Artist artist = artistRepository.findById(id);
        if (artist == null) {
            System.out.println("Artist not found!");
            return new ResponseEntity<Artist>(HttpStatus.NOT_FOUND);
        }
        partialUpdate(artist,updates);
        return new ResponseEntity<Artist>(HttpStatus.NO_CONTENT);
    }

    private void partialUpdate(Artist artist, Map<String, Object> updates) {
        if (updates.containsKey("votes")) {
            artist.setVotes((Integer) updates.get("votes"));
        }
        if (updates.containsKey("approved")) {
            artist.setApproved((Integer) updates.get("approved"));
        }
        artistRepository.save(artist);
    }
}

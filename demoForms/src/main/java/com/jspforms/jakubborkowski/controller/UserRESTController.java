package com.jspforms.jakubborkowski.controller;

import com.jspforms.jakubborkowski.model.Artist;
import com.jspforms.jakubborkowski.model.Contact;
import com.jspforms.jakubborkowski.model.User;
import com.jspforms.jakubborkowski.repository.ArtistRepository;
import com.jspforms.jakubborkowski.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/user")
public class UserRESTController {
    private UserRepository userRepository;


    @Autowired
    public void ArtistRestController(UserRepository userRepository) {this.userRepository = userRepository;}


    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<User> findAllUsers() {return userRepository.findAll();}


    @RequestMapping(value="/{id}", method = RequestMethod.PATCH)
    //@PatchMapping("/{id}")
    public ResponseEntity<User> updatePartOfUser(@RequestBody Map<String, Object> updates, @PathVariable("id") int id) {
        User user = userRepository.findById(id);
        if (user == null) {
            System.out.println("User not found!");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        partialUpdate(user,updates);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    private void partialUpdate(User user, Map<String, Object> updates) {
        if (updates.containsKey("votes")) {
            user.setVotes((Integer) updates.get("votes"));
        }
        if (updates.containsKey("choice")) {
            user.setChoice((Integer) updates.get("choice"));
        }
        userRepository.save(user);
    }
}





package com.jspforms.jakubborkowski.controller;

import com.jspforms.jakubborkowski.model.Contact;
import com.jspforms.jakubborkowski.model.Room;
import com.jspforms.jakubborkowski.repository.ContactRepository;
import com.jspforms.jakubborkowski.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;




@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/rooms")
public class RoomRestController {
    private RoomRepository roomRepository;

    @Autowired
    public RoomRestController(RoomRepository roomRepository) {this.roomRepository = roomRepository;}

    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public List<Room> findAllRooms() {return roomRepository.findAll();}

    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public ResponseEntity<Contact> addRoom(@RequestBody Room room){
        roomRepository.save(room);
        return new ResponseEntity<Contact>(HttpStatus.CREATED);
    }






    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    //@GetMapping("/{id}")
    public Object findRoom (@PathVariable("id") int id) {
        Room room = roomRepository.findById(id);
        if (room == null) {
            System.out.println("Contact not found!");
            return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
        }

        return roomRepository.findById(id);
    }


    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    //@DeleteMapping("/{id}")
    public ResponseEntity<Room> deleteRoom (@PathVariable("id") int id) {
        Room room = roomRepository.findById(id);
        if (room == null) {
            System.out.println("Contact not found!");
            return new ResponseEntity<Room>(HttpStatus.NOT_FOUND);
        }

        roomRepository.deleteById(id);
        return new ResponseEntity<Room>(HttpStatus.NO_CONTENT);
    }
/*
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteContact (@RequestBody Contact contact) {
        contactRepository.deleteAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    //@PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact, @PathVariable("id") long id) {
        contact.setId(id);
        contactRepository.save(contact);
        return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
    }
*/


};










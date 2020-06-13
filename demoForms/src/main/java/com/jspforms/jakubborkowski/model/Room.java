package com.jspforms.jakubborkowski.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {


    @Id
    @GeneratedValue
    private int room_id;
    private int capacity;
    private int id;

    public long getId() {
        return id;
    }

    public void setid(long id) {
        this.id = (int) id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
}

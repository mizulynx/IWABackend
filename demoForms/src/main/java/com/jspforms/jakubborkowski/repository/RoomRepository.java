package com.jspforms.jakubborkowski.repository;

import com.jspforms.jakubborkowski.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
    Room findById(int room_id);
    Room deleteById(int room_id);
}

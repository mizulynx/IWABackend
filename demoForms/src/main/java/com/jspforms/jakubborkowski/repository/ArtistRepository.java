package com.jspforms.jakubborkowski.repository;

import com.jspforms.jakubborkowski.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface ArtistRepository extends JpaRepository<Artist, Long> {
        Artist findById(int id);
        Artist deleteById(int id);
    }

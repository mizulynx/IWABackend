package com.jspforms.jakubborkowski.repository;

import com.jspforms.jakubborkowski.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
    public interface ArtistRepository extends JpaRepository<Artist, Long> {
        Artist findById(long id);
        Artist findAllByGenre(String genre);
        @Transactional
        Artist deleteById(long id);
    }

package com.jspforms.jakubborkowski.repository;


import com.jspforms.jakubborkowski.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findById(long id);
}

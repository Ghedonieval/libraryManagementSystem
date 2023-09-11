package com.librarymanagementsystem.repo;

import com.librarymanagementsystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface bookRepository extends JpaRepository<Book , Long> {
    public Book findByIsbnNumber(long isbnNumber);

}

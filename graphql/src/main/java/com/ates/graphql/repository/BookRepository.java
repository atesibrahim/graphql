package com.ates.graphql.repository;

import com.ates.graphql.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByTitle(String title);
}

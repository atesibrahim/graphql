package com.ates.graphql.resolver;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ates.graphql.domain.Book;
import com.ates.graphql.model.BookInput;
import com.ates.graphql.repository.BookRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BookQuery{

    private final BookRepository bookRepository;

    @QueryMapping
    public Iterable<Book> allBook(){
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book getBookByTitle(@Argument("filter") BookInput bookInput){
        return bookRepository.findBookByTitle(bookInput.getTitle());
    }

}

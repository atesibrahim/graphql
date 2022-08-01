package com.ates.graphql.resolver;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.ates.graphql.domain.Book;
import com.ates.graphql.model.BookInput;
import com.ates.graphql.model.BookOutput;
import com.ates.graphql.model.NewBook;
import com.ates.graphql.repository.BookRepository;

import lombok.AllArgsConstructor;

import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;

@Controller
@AllArgsConstructor
public class BookMutation {

    BookRepository bookRepository;

    @MutationMapping
    public BookOutput newBook(@Argument("input") NewBook newBook){
        Book book =  Book.builder().authorName(newBook.getAuthorName()).title(newBook.getTitle()).build();
        Book book1 = bookRepository.save(book);
        return BookOutput.builder().authorName(book1.getAuthorName()).title(book1.getTitle()).build();
    }

    @MutationMapping
    public BookOutput deleteBook(@Argument("input") BookInput bookInput){
        Book deleteBook = new Book();
        Optional<Book> findBook =  bookRepository.findById(bookInput.getId());
        if(findBook.isPresent()){
            bookRepository.delete(findBook.get());
            deleteBook = findBook.get();
        }
        return BookOutput.builder().id(deleteBook.getId()).title(deleteBook.getTitle()).authorName(deleteBook.getAuthorName()).build();
    }
}
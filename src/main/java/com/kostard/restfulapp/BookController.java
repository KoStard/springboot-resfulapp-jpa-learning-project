package com.kostard.restfulapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        var result = StreamSupport.stream(bookRepository.findAll().spliterator(), false).collect(Collectors.toList());
        log.info("{}", result);
        return result;
    }

    @GetMapping("/book")
    public Book getBook(@RequestParam(value = "id") Optional<Long> id,
                        @RequestParam(value = "author") Optional<String> author) {
        if (id.isEmpty() && author.isEmpty()) {
            throw new RuntimeException("Must provide either id or author");
        }
        if (id.isPresent() && author.isPresent()) {
            throw new RuntimeException("Must provide either id or author");
        }
        if (id.isPresent()) {
            return getBookById(id.get());
        }
        return getBookByAuthor(author.get());
    }

    private Book getBookByAuthor(String author) {
        return bookRepository.findByAuthor(author).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    private Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }
}

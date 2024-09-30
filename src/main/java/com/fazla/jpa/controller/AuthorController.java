package com.fazla.jpa.controller;

import com.fazla.jpa.models.Author;
import com.fazla.jpa.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/getAuthors")
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    @PostMapping("/addAuthor")
    public Author addAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

}

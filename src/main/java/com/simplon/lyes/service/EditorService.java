package com.simplon.lyes.service;

import com.simplon.lyes.repository.JsonRepository;
import com.simplon.lyes.modele.Book;

public class EditorService {
    JsonRepository jsonRepository;

    public EditorService() {
        jsonRepository = new JsonRepository("library");
    }

    public void addBookToLibrary(Book book) {
        jsonRepository.addBook(book);
    }

    public void saveBook(Book book) {
        jsonRepository.saveBook(book);
    }
}

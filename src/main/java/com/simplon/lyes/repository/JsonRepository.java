package com.simplon.lyes.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.simplon.lyes.modele.Book;

import java.io.File;
import java.io.IOException;

public class JsonRepository {
    String path;

    public JsonRepository(String subDir) {
        this.path = System.getProperty("user.home") + "/ldvelh/" + subDir;      // premet de récupérer un chemin d'un dossier
        System.out.println("path : " + path);
        // permet de create directory if not exist
        File directory = new File(path);
        if (! directory.exists()){
            System.out.println("Trying to Create path : " + path);
            boolean success= directory.mkdirs();
            System.out.println(success);
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }
    }

    //création du fichier content.json et le nom du livre
    public void addBook(Book book) {
        String bookDirectory = path + "/" + book.getTitle();
        File directory = new File(bookDirectory);
        directory.mkdir();
        saveBook(book);
    }

    public void saveBook(Book book) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path + "/" + book.getTitle() + "/content.json"), book);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


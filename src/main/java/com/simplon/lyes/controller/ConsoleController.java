package com.simplon.lyes.controller;

import com.simplon.lyes.modele.Book;
import com.simplon.lyes.modele.Chapter;
import com.simplon.lyes.service.EditorService;
import com.simplon.lyes.service.PlayerService;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsoleController {
    //permet à l'utilisateur d'agir sur l'application
    boolean keepEditing;
    boolean editBook;
    boolean editChapter;
    Book currentBook;
    Chapter currentChapter;
    Chapter currentText;
    EditorService editorService;
    PlayerService playerService;
    Menus menus;
    Scanner scan;

    public boolean isKeepEditing() {
        return keepEditing;
    }

    public void setKeepEditing(boolean keepEditing) {
        this.keepEditing = keepEditing;
    }

    public boolean isEditBook() {
        return editBook;
    }

    public void setEditBook(boolean editBook) {
        this.editBook = editBook;
    }

    public boolean isEditChapter() {
        return editChapter;
    }

    public void setEditChapter(boolean editChapter) {
        this.editChapter = editChapter;
    }

    public ConsoleController() {

        this(new EditorService(), new PlayerService());
    }

    public ConsoleController(EditorService editorService, PlayerService playerService) {
        this.editorService = editorService;
        this.playerService = playerService;
        menus = new Menus();
        keepEditing = true;
        editBook = false;
        editChapter = false;
        scan = new Scanner(System.in);
        currentBook = null;
        currentChapter = null;
        currentText = null;
    }

    public void startApp() {
        showMenu(MenuType.MAIN);
        scan.close();
    }

    public String getUserSelection() {
        return scan.nextLine();
    }

    public void quitMenu(MenuType type) {
        switch (type){

            case MAIN -> {
                keepEditing = true;
            }
            case BOOK -> {
                editBook = false;
            }
            case CHAPTER -> {
                editChapter = false;
            }
        }
    }

    public void createBook() {
        System.out.println("what is the book title");
        String title = scan.nextLine(); //bloque l'execution et attend la réponse utilisateur puis appuie sur ok pour recuperer l'info
        currentBook = new Book(title);
        editorService.addBookToLibrary(currentBook);
        showMenu(MenuType.BOOK);
    }

    public void showMenu(MenuType type){
        Supplier<Boolean> condition = null;
        Consumer<ConsoleController> menu = null; // Consumer est une interface qui permet de maper une seule entrée et ne renvoie rien
        switch (type) {
            case MAIN -> {
                condition = this::isKeepEditing;
                menu = menus::displayMainMenu; // référence sur les méthodes
            }
            case BOOK -> {
                editBook = true;
                condition = this::isEditBook;
                menu = menus::displayEditBookMenu;
            }
            case CHAPTER -> {
                editChapter = true;
                condition = this::isEditChapter;
                menu = menus::displayEditChapterMenu;
            }
        }
        while(condition.get()){
           menu.accept(this);
        }
    }

    public void createNewChapter(){
        currentChapter = new Chapter();
        if(currentBook != null){
            currentBook.addChapter(currentChapter);
            showMenu(MenuType.CHAPTER);
        }else{
            System.out.println("warning you have not chosen the book to which add this new chapter");
        }
    }

    public void addTextToChapter() {
        if (currentChapter != null){
            String text = scan.nextLine();
            currentChapter.setText(text);
        }
    }

    public void saveChanges() {
        if (currentBook != null){
            editorService.saveBook(currentBook);
        }

    }
}

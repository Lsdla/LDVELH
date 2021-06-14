package com.simplon.lyes.modele;

import java.util.Map;

public class Chapter {

    // Warning, this index should be reseted when changing
    private static int globalIndex = 0; //permet d'incrémenter les numéro de chapitres sans ecraser les existants et sans avoir les doublons
    Integer id;
    String caption;
    String text;
    Map<Integer, Chapter>option;
    private boolean intro;
    private boolean end;

    /**
     * Default constructor
     */
    public Chapter() {
        id = globalIndex++;
    }


    /**
     * @param newText
     */
    public void addText(String newText) {

    }


    /**
     * @param modifiedText
     */
    public void changeTexte(String modifiedText) {
        // TODO implement here
    }

    public void deleteText() {
        // TODO implement here
    }


    /**
     * @param selectedChapter 
     * @return
     */
    public State selectLinkedChapter(int selectedChapter) {
        // TODO implement here
        return null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isIntro() {
        return intro;
    }

    public void setIntro(boolean intro) {
        this.intro = intro;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}

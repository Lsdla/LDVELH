package com.simplon.lyes.controller;

public class Menus {
    public void displayMainMenu(ConsoleController controller){
        System.out.println("Select your option");
        int i = 0;
        System.out.println(" -1 : To quit the application");
        System.out.println((++i) + ": Create a new book");
        System.out.println((++i) + ": Delete a new book");
        System.out.println((++i) + ": Modify a new book");
        System.out.println((++i) + ": Publish a new book");
        System.out.println((++i) + ": Save Changes");

        String choice = controller.getUserSelection();

        switch (choice){
            case "-1" -> controller.quitMenu(MenuType.MAIN);
            case "1" -> controller.createBook();
            case "5" -> controller.saveChanges();
        }
    };

    public void displayEditMenu(ConsoleController controller){
        
    };

    public void displayEditBookMenu(ConsoleController controller){
        System.out.println("Select your option");
        int i = 0;
        System.out.println(" -1 : Back to previous Menu");
        System.out.println((++i) + ": Create a new chapter");
        System.out.println((++i) + ": Modify an existing chapter");
        System.out.println((++i) + ": Delete a chapter");
        System.out.println((++i) + ": Define end state chapter");
        System.out.println((++i) + ": Save Changes");

        String choice = controller.getUserSelection();

        switch (choice){
            case "-1" -> controller.quitMenu(MenuType.BOOK);
            case "1" -> controller.createNewChapter();
            case "5" -> controller.saveChanges();
        }
    };

    public void displayEditChapterMenu(ConsoleController controller){
        System.out.println("Select your option");
        int i = 0;
        System.out.println(" -1 : Back to previous Menu");
        System.out.println((++i) + ": Add - Modify text");
        System.out.println((++i) + ": Add - Modify Caption");
        System.out.println((++i) + ": Add Chapter Link Options");
        System.out.println((++i) + ": Change Intro Status");
        System.out.println((++i) + ": Change End Status");
        System.out.println((++i) + ": Save Changes");

        String choice = controller.getUserSelection();

        switch (choice){
            case "-1" -> controller.quitMenu(MenuType.CHAPTER);
            case "1" -> controller.addTextToChapter();
            case "6" -> controller.saveChanges();
        }
    };

}

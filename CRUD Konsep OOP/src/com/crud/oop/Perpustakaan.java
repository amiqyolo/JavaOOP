package com.crud.oop;

public class Perpustakaan {
    // field
    private String primaryKey;
    private String type;
    private String title;
    private String author;
    private String publisher;

    // construktor
    public Perpustakaan(String primaryKey, String type, String title, String author, String publisher){
        super();
        this.primaryKey = primaryKey;
        this.type = type;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    // getter
    public String getPrimaryKey() {
        return primaryKey;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getPublisher(){
        return publisher;
    }

    // setter
    public void setType(String type) {
        this.type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

}

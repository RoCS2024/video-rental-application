package com.video.rental.app.model.item;

/**
 * POJO class for Item objects.
 * */
public class Item {
    private String id;
    private String title;
    private String genre;
    private int copies;

    public Item() {
    }

    public Item(String id, String title, String genre, int copies) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.copies = copies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

}


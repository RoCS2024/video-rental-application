package com.video.rental.app.model.item;

/**
 * POJO class for Item objects. This class represents the video rental items that can be rented from the store.
 * */
public class Item {
    /** A unique id of the item. */
    private String id;
    /** The title of the video material/item. */
    private String title;
    /** The specific genre of the item. */
    private String genre;
    /** Number of copies of the item. */
    private int copies;

    /***
     * Default constructor of the Item class.
     *
     */
    public Item() {
    }

    /***
     * An Item class constructor that initializes the id, title, genre and copies of the Item instance.
     * @param id the id of the video rental item.
     * @param title the title of the video rental item.
     * @param genre the genre of the video rental item.
     * @param copies the number of copies of the item.
     */
    public Item(String id, String title, String genre, int copies) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.copies = copies;
    }

    /**
     * Retrieves the id of the item.
     * @return the id of the item.
     * */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the item.
     * @param id the id of the item.
     * */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the title of the item.
     * @return the title of the item.
     * */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the item.
     * @param title the title of the item.
     * */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Retrieves the genre of the item.
     * @return the genre of the item.
     * */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the item.
     * @param genre the genre of the item.
     * */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Retrieves the number of copies of the item.
     * @return the number of copies of the item.
     * */
    public int getCopies() {
        return copies;
    }

    /**
     * Sets the number of copies of the item.
     * @param copies number of copies of the item.
     * */
    public void setCopies(int copies) {
        this.copies = copies;
    }

}


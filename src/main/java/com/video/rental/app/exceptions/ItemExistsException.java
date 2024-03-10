package com.video.rental.app.exceptions;

public class ItemExistsException extends Exception{
    public ItemExistsException(String message) {
        super(message);
    }
}

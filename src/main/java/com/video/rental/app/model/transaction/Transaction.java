package com.video.rental.app.model.transaction;

import java.sql.Timestamp;

/**
 * POJO class for Transaction objects
 * */
public class Transaction {
    private long id;
    private String customerId;
    private String itemId;
    private Timestamp rentDate;
    private Timestamp dueDate;
    private Timestamp returnDate;

    public Transaction() {
    }

    public Transaction(String customerId, String itemId, Timestamp rentDate, Timestamp dueDate, Timestamp returnDate) {
        this.customerId = customerId;
        this.itemId = itemId;
        this.rentDate = rentDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public Transaction(long id, String customerId, String itemId, Timestamp rentDate, Timestamp dueDate, Timestamp returnDate) {
        this.id = id;
        this.customerId = customerId;
        this.itemId = itemId;
        this.rentDate = rentDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Timestamp getRentDate() {
        return rentDate;
    }

    public void setRentDate(Timestamp rentDate) {
        this.rentDate = rentDate;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }
}
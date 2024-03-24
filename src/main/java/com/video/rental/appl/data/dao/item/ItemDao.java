package com.video.rental.appl.data.dao.item;

import com.video.rental.appl.model.item.Item;

import java.util.List;

/**
 * Interface for Item Data Access Object.
 * */
public interface ItemDao {
    /**
     * Retrieves all Items from the database.
     *
     * @return list of all items.
     * */
    List<Item> getAllItems();

    /**
     * Retrieves an Item from the database with specified id.
     *
     * @param id the id of the item.
     * @return the Item.
     * */
    Item getItemById(String id);

    /**
     * Retrieves a list of Items from the database from a list of ids.
     *
     * @param ids list of ids.
     * @return list of all items.
     * */
    List<Item> getItemsByIdList(List<String> ids);

    /**
     * Adds an Item to the database.
     *
     * @param item item to add.
     * @return true if adding is successful.
     * */
    boolean addItem(Item item);

    /**
     * Updates an Item in the database.
     *
     * @param item the item to update.
     * @return true if update is successful.
     * */
    boolean updateItem(Item item);

    /**
     * Removes an item from the database.
     *
     * @param id the id of the item to be removed.
     * @return true if deletion is successful.
     * */
    boolean deleteItemById(String id);

}

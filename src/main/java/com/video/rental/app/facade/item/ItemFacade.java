package com.video.rental.app.facade.item;

import com.video.rental.app.exceptions.ItemExistsException;
import com.video.rental.app.exceptions.ItemNotFoundException;
import com.video.rental.app.model.item.Item;

import java.util.List;

public interface ItemFacade {

    List<Item> getAllItems();

    Item getItemById(String id);

    List<Item> getItemsByIdList(List<String> ids);

    boolean addItem(Item item) throws ItemExistsException;

    boolean updateItem(Item item) throws ItemNotFoundException;

    boolean deleteItemById(String id) throws ItemNotFoundException;
}

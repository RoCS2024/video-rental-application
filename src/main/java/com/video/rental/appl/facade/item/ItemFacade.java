package com.video.rental.appl.facade.item;

import com.video.rental.appl.exceptions.ItemExistsException;
import com.video.rental.appl.exceptions.ItemNotFoundException;
import com.video.rental.appl.model.item.Item;

import java.util.List;

public interface ItemFacade {

    List<Item> getAllItems();

    Item getItemById(String id);

    List<Item> getItemsByIdList(List<String> ids);

    boolean addItem(Item item) throws ItemExistsException;

    boolean updateItem(Item item) throws ItemNotFoundException;

    boolean deleteItemById(String id) throws ItemNotFoundException;
}

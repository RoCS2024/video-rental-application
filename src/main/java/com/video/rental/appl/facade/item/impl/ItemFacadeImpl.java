package com.video.rental.appl.facade.item.impl;

import com.video.rental.appl.data.dao.item.ItemDao;
import com.video.rental.appl.data.dao.item.impl.ItemDaoImpl;
import com.video.rental.appl.exceptions.ItemExistsException;
import com.video.rental.appl.exceptions.ItemNotFoundException;
import com.video.rental.appl.facade.item.ItemFacade;
import com.video.rental.appl.model.item.Item;

import java.util.List;

public class ItemFacadeImpl implements ItemFacade {
    private ItemDao itemDao = new ItemDaoImpl();

    @Override
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }

    @Override
    public Item getItemById(String id) {
        return itemDao.getItemById(id);
    }

    @Override
    public List<Item> getItemsByIdList(List<String> ids) {
        return itemDao.getItemsByIdList(ids);
    }

    @Override
    public boolean addItem(Item item) throws ItemExistsException {
        boolean result = false;
        Item targetItem = getItemById(item.getId());
        if(targetItem != null) {
            throw new ItemExistsException("Item to add already exists. ");
        }
        result = itemDao.addItem(item);
        return result;
    }

    @Override
    public boolean updateItem(Item item) throws ItemNotFoundException {
        boolean result = false;
        Item targetItem = itemDao.getItemById(item.getId());
        if(targetItem == null) {
            throw new ItemNotFoundException("Item to update not found. ");
        }
        result = itemDao.updateItem(item);
        return result;
    }

    @Override
    public boolean deleteItemById(String id) throws ItemNotFoundException {
        boolean result = false;
        Item targetItem = new Item();
        targetItem = itemDao.getItemById(id);
        if(targetItem == null) {
            throw new ItemNotFoundException("Item to delete not found. ");
        }
        result = itemDao.deleteItemById(id);
        return result;
    }
}

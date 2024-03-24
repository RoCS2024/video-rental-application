package com.video.rental.appl.data.dao.item.impl;

import com.video.rental.appl.data.dao.item.ItemDao;
import com.video.rental.appl.model.item.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ItemDaoImplTest {

    private ItemDao itemDao;

    private List<Item> itemList;

    @BeforeEach
    public void setup() {
        itemList = new ArrayList<>();
        Item item1 = new Item("1", "Dirty Dancing", "Romance", 3);
        Item item2 = new Item("2", "The Greatest Showman", "Musical", 4);
        itemList.add(item1);
        itemList.add(item2);

        itemDao = mock(ItemDao.class);
    }


    @Test
    public void testGetAllItems() {
        //Call Part
        when(itemDao.getAllItems()).thenReturn(itemList);

        List<Item> expectedResult = itemDao.getAllItems();

        //Assertion Part
        assertEquals(expectedResult.size(), 2);
        assertNotEquals(expectedResult, null);
    }

    @Test
    public void testGetItemById() {
        Item item1 = new Item("1", "Dirty Dancing", "Romance", 3);

        when(itemDao.getItemById("1")).thenReturn(item1);

        Item expectedItem = itemDao.getItemById("1");

        assertEquals(expectedItem, item1);
        assertEquals(expectedItem.getTitle(), item1.getTitle());
    }

    //Challenge: Create unit tests for add, update and delete items.

}
package com.video.rental.appl.facade.item.impl;

import com.video.rental.appl.data.dao.item.ItemDao;
import com.video.rental.appl.exceptions.ItemNotFoundException;
import com.video.rental.appl.facade.item.ItemFacade;
import com.video.rental.appl.model.item.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.mockito.Mockito.*;

public class ItemFacadeImplTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemFacadeImplTest.class);

    @InjectMocks
    private ItemFacade itemFacade = new ItemFacadeImpl();

    @Mock
    private ItemDao itemDao;

    @Mock
    private List<Item> itemList;

    @Mock
    private Item item;

    @Mock
    private Item addItem;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        item.setId("1");
        addItem.setId("2");
        when(itemDao.getAllItems()).thenReturn(itemList);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    public void testGetAllItems() {
        List expectedList = itemFacade.getAllItems();

        // Assert that expectedList and itemList are equal
        assert(expectedList.equals(itemList));
        // Verify that the itemDao.getAllItems is called whenever itemFacade.getAllItems is invoked.
        verify(itemDao).getAllItems();
    }

    @Test
    public void testGetItemById() {
        when(itemDao.getItemById("1")).thenReturn(item);
        Item expectedItem = itemFacade.getItemById("1");

        // Assert that expectedItem and item are equal
        assert(expectedItem.equals(item));
        // verify that when calling itemFacade.getItemById(), the itemDao.getItemById() is called.
        verify(itemDao).getItemById("1");
    }

    @Test
    public void testAddItem() {
        try {
            when(itemFacade.getItemById(addItem.getId())).thenReturn(null);
            when(itemDao.addItem(addItem)).thenReturn(true);

            boolean result = itemFacade.addItem(addItem);

            // Assert that when adding an item, it returns true if successful
            assert(result == true);
            // Assert that addItem is not in the database
            assert(itemFacade.getItemById("2") == null);
            // Verify that itemDao.addItem() is called when itemFacade.addItem() is invoked
            verify(itemDao).addItem(addItem);
        } catch (Exception e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }

    }

    @Test
    public void testUpdateItem() {
        try {
            when(itemDao.getItemById(item.getId())).thenReturn(item);
            when(itemDao.updateItem(item)).thenReturn(true);

            boolean result = itemFacade.updateItem(item);

            // Assert that when updating an item, it returns true if successful
            assert(result == true);
            // Assert that item to update is in the database
            assert(itemFacade.getItemById("1").equals(item));
            // Verify that itemDao.updateItem() is called when itemFacade.updateItem() is invoked
            verify(itemDao).updateItem(item);
        } catch (ItemNotFoundException e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }
    }

    @Test
    public void testDeleteItem() {
        try {
            when(itemDao.getItemById(item.getId())).thenReturn(item);
            when(itemDao.deleteItemById(item.getId())).thenReturn(true);

            boolean result = itemFacade.deleteItemById(item.getId());

            // Assert that when deleting an item, it returns true if successful
            assert(result == true);
            // Verify that itemDao.deleteItemById() is called when itemFacade.deleteItemById() is invoked
            verify(itemDao).deleteItemById(item.getId());
        } catch (ItemNotFoundException e) {
            LOGGER.error("Exception caught: " + e.getMessage());
        }
    }

}
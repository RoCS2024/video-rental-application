package com.video.rental.appl.data.dao.item.impl;

import com.video.rental.appl.data.connection.ConnectionHelper;
import com.video.rental.appl.data.utils.QueryConstants;
import com.video.rental.appl.data.dao.item.ItemDao;
import com.video.rental.appl.model.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation class of the Item Data Access Object.
 *
 * */
public class ItemDaoImpl implements ItemDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(ItemDaoImpl.class);

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        try (Connection con = new ConnectionHelper().getConnection()){
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ALL_ITEMS_STATEMENT);
            ResultSet rs= statement.executeQuery();

            while(rs.next()) {
                itemList.add(setItem(rs));
            }
            LOGGER.debug("Items retrieved successfully.");

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Item database is empty.");
        return itemList;
    }

    @Override
    public Item getItemById(String id) {
        Item item = null;
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ITEM_BY_ID_STATEMENT);
            statement.setString(1, id);
            ResultSet rs= statement.executeQuery();

            if(rs.next()) {
                LOGGER.debug("Item retrieved successfully.");
                item = setItem(rs);
            }

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Item not found.");
        return item;
    }

    @Override
    public List<Item> getItemsByIdList(List<String> ids) {
        List<Item> itemList = new ArrayList<>();
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstants.GET_ITEMS_BY_IDS_STATEMENT + buildParameters(ids));
            for(int i=1; i<=ids.size(); i++) {
                statement.setString(i, ids.get(i-1));
            }
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                itemList.add(setItem(rs));
            }

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        return itemList;
    }

    @Override
    public boolean addItem(Item item) {
        int result = 0;
        try (Connection con = new ConnectionHelper().getConnection()){
            PreparedStatement statement = con.prepareStatement(QueryConstants.ADD_ITEM_STATEMENT);
            statement.setString(1, item.getId());
            statement.setString(2, item.getTitle());
            statement.setString(3, item.getGenre());
            statement.setInt(4, item.getCopies());
            result = statement.executeUpdate();
            if(result == 1) {
                LOGGER.debug("Item successfully added.");
                return true;
            }

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Adding item failed.");
        return false;
    }

    @Override
    public boolean updateItem(Item item) {
        int result = 0;
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstants.UPDATE_ITEM_STATEMENT);
            statement.setString(1, item.getTitle());
            statement.setString(2, item.getGenre());
            statement.setString(3, String.valueOf(item.getCopies()));
            statement.setString(4, item.getId());
            result = statement.executeUpdate();
            if(result == 1) {
                LOGGER.debug("Item successfully updated.");
                return true;
            }
        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Updating item failed.");
        return false;
    }

    @Override
    public boolean deleteItemById(String id) {
        int result = 0;
        try (Connection con = new ConnectionHelper().getConnection()) {
            PreparedStatement statement = con.prepareStatement(QueryConstants.DELETE_ITEM_BY_ID_STATEMENT);
            statement.setString(1, id);
            result = statement.executeUpdate();

            if(result == 1) {
                LOGGER.debug("Item successfully deleted.");
                return true;
            }

        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("Deleting item failed.");
        return false;
    }

    /**
     * Creates a new Item object from the ResultSet obtained from the query.
     * @param rs the ResultSet from the query.
     * @return the item created.
     * */
    private Item setItem(ResultSet rs) {
        try {
            Item item = new Item();
            item.setId(rs.getString("id"));
            item.setTitle(rs.getString("title"));
            item.setGenre(rs.getString("genre"));
            item.setCopies(Integer.parseInt(rs.getString("copies")));
            return item;
        } catch (SQLException ex) {
            LOGGER.error("An SQL Exception occurred." + ex.getMessage());
        }
        LOGGER.debug("No item was set.");
        return null;
    }

    /**
     * Builds a string of parameters that will be used in the query.
     * @param ids list of ids of items.
     * @return string of parameters.
     * */
    private String buildParameters(List<String> ids) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for(String id: ids) {
            sb.append("?, ");
        }

        //delete the last character added which is " "
        String params = sb.deleteCharAt(sb.length()-1).toString();

        //delete the second to the last character added which is ","
        params = sb.deleteCharAt(sb.length()-1).toString();
        params = params + ")";

        return params;
    }
}

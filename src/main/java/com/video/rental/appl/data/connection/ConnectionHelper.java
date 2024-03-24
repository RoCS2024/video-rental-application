package com.video.rental.appl.data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The ConnectionHelper class connects to an Oracle database.
 */
public class ConnectionHelper {
    /** The connection URL. */
    public static final String URL = "jdbc:oracle:thin:@localhost:1521:oracleDB";
    /** The Oracle driver. */
    public static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    /** The username used to connect to the database. */
    public static final String USERNAME = "system";
    /** The password used to connect to the database. */
    public static final String PASSWORD = "Changeme0";

    /**
     * This method gets the connection from an Oracle database instance.
     * */
    public static Connection getConnection() {
        try {
            Class.forName(ORACLE_DRIVER).newInstance();
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            //LOGGER.error("Error has occurred. Driver not found.")
        } catch (InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
            //LOGGER.error("Error has occurred. Driver not found.")
        } catch (SQLException ex) {
            ex.printStackTrace();
            //LOGGER.error("Error has occurred. Cannot connect to the database." + ex.getMessage())
        }
        return null;
    }
}

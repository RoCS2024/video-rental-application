package com.video.rental.app;

import com.video.rental.app.data.connection.ConnectionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;

public class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Starting application...");
        Connection connection = ConnectionHelper.getConnection();
    }
}

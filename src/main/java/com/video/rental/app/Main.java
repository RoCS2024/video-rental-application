package com.video.rental.app;

import com.video.rental.app.data.connection.ConnectionHelper;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Connection connection = ConnectionHelper.getConnection();
    }
}

package com.bridgelabz.db;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;

public class Base {

    public static Connection con;
    public static Statement stmt = null;
    public static String dbUrl = "jdbc:mysql://localhost:3306/spotify_Api";
    public static String userName = "root";
    public static String password = "root123";
    static ResultSet result;

    @BeforeTest
    public void getVariable_Values() throws SQLException {
        con = DriverManager.getConnection(dbUrl,userName,password);
        stmt = con.createStatement();
        System.out.println("stmt : " + stmt);
        System.out.println("con : " + con);
    }

    @AfterTest
    public static void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

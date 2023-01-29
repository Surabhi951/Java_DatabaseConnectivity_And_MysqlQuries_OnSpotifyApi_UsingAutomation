package com.bridgelabz.db;

import java.sql.*;

public class DbAutomation {

    public static Connection con;
    public static Statement stmt = null;
    public static String dbUrl = "jdbc:mysql://localhost:3306/spotify_Api";
    public static String userName = "root";
    public static String password = "root123";
    static ResultSet result;

    public static void main(String[] args) throws SQLException {
        con = DriverManager.getConnection(dbUrl, userName, password);
        stmt = con.createStatement();
        System.out.println("stmt : " + stmt);
        System.out.println("con : " + con);

        PreparedStatement preparedStatement = con.prepareStatement("insert into user values" + "(?,?,?)");
        preparedStatement.setString(1, "6");
        preparedStatement.setString(2, "Mandakini");
        preparedStatement.setString(3, "Mandakini@gmail.com");
        preparedStatement.executeUpdate();

        printData();

        con.close();
    }

    public static void printData() throws SQLException {
        result = stmt.executeQuery("select * from user");
        while (result.next()) {
            String userId = result.getString(1);
            String userName = result.getString("userName");
            String userEmail = result.getString("userEmail");
            System.out.println(userId + " " + userName + " " + userEmail);
        }
    }
}
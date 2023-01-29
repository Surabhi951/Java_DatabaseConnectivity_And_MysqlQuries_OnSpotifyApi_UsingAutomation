//*****************************************
//Author Name : Surabhi Bhagat
//Project     : Database Automation
//Date        : 29/01/2023
//*****************************************

package com.bridgelabz.db;

import org.testng.annotations.Test;

import java.sql.*;

public class DbAutomationTest extends Base {

    @Test
    public void getTableData_Successfully() throws SQLException {
        result = stmt.executeQuery("select * from user");
        while (result.next()) {
            String userId = result.getString(1);
            String userName = result.getString("userName");
            String userEmail = result.getString("userEmail");
            System.out.println(userId + " " + userName + " " + userEmail);
        }
    }

    @Test
    public void insertDataIntoTable_Successfully() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("insert into user values" + "(?,?,?)");
        preparedStatement.setString(1, "6");
        preparedStatement.setString(2, "Mandakini");
        preparedStatement.setString(3, "Mandakini@gmail.com");
        preparedStatement.executeUpdate();
        getTableData_Successfully();
    }

    @Test
    public void UpdateDataIntoTable_Successfully() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("update user set userName = ? where userId = ?");
        preparedStatement.setString(1, "Mandhuri");
        preparedStatement.setString(2, "4");
        preparedStatement.executeUpdate();
        getTableData_Successfully();
    }

    @Test
    public void deleteDataIntoTable_Successfully() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("Delete from user where userId = ?");
        preparedStatement.setString(1, "6");
        preparedStatement.executeUpdate();
        getTableData_Successfully();
    }
}

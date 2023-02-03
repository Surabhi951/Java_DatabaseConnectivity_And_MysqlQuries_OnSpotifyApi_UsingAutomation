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

    @Test
    public void getPlaylistTableData_Successfully() throws SQLException {
        result = stmt.executeQuery("select * from playlist");
        while (result.next()) {
            String playlistId = result.getString(1);
            String playlistName = result.getString("playlistName");
            String userId = result.getString("userId");
            System.out.println(playlistId + " " + playlistName + " " + userId);
        }
    }

    @Test
    public void insertPlaylistDataIntoTable_Successfully() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("insert into playlist values" + "(?,?,?)");
        preparedStatement.setString(1, "6");
        preparedStatement.setString(2, "Dil Playlist");
        preparedStatement.setString(3, "5");
        preparedStatement.executeUpdate();
        getTableData_Successfully();
    }

    @Test
    public void UpdatePlaylistDataIntoTable_Successfully() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("update playlist set playlistName = ? where userId = ?");
        preparedStatement.setString(1, "Hum Dil De Chuke Sanam");
        preparedStatement.setString(2, "4");
        preparedStatement.executeUpdate();
        getTableData_Successfully();
    }

    @Test
    public void deletePlaylistDataIntoTable_Successfully() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("Delete from playlist where playlistId = ?");
        preparedStatement.setString(1, "6");
        preparedStatement.executeUpdate();
        getTableData_Successfully();
    }

    @Test
    public void getTracksTableData_Successfully() throws SQLException {
        result = stmt.executeQuery("select * from tracks");
        while (result.next()) {
            String trackId = result.getString(1);
            String trackName = result.getString("trackName");
            String playlistId = result.getString("playlistId");
            System.out.println(trackId + " " + trackName + " " + playlistId);
        }
    }

    @Test
    public void insertTracksTableData_Successfully() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("insert into tracks values" + "(?,?,?)");
        preparedStatement.setString(1,"7");
        preparedStatement.setString(2,"DDLG");
        preparedStatement.setString(3,"4");
        preparedStatement.executeUpdate();
        getTableData_Successfully();
    }

    @Test
    public void UpdateTracksDataIntoTable_Successfully() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("update tracks set trackName = ? where playlistId = ?");
        preparedStatement.setString(1, "Ae Dil Hai Mushkil");
        preparedStatement.setString(2, "5");
        preparedStatement.executeUpdate();
        getTableData_Successfully();
    }

    @Test
    public void deleteTracksDataIntoTable_Successfully() throws SQLException {
        PreparedStatement preparedStatement = con.prepareStatement("Delete from tracks where playlistId = ?");
        preparedStatement.setString(1, "5");
        preparedStatement.executeUpdate();
        getTableData_Successfully();
    }
}

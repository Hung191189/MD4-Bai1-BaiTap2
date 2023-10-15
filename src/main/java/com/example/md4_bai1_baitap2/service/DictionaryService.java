package com.example.md4_bai1_baitap2.service;

import com.example.md4_bai1_baitap2.model.Dictionary;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DictionaryService {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            java.lang.Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dictionary?useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void create(Dictionary dictionary){
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into dictionary (english, vietnamese) values (?, ?)")){
            preparedStatement.setString(1, dictionary.getEnglish());
            preparedStatement.setString(2, dictionary.getVietnamese());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public List<Dictionary> displayAll() {
        List<Dictionary> dictionaryList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from dictionary")){
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String english = rs.getString("english");
                String vietnamese = rs.getString("vietnamese");
                dictionaryList.add(new Dictionary(english, vietnamese));
            }
        } catch (SQLException e) {
        }
        return dictionaryList;
    }

}

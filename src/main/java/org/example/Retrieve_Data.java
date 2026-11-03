package org.example;

import java.sql.*;

public class Retrieve_Data {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/company_db";
        String USER = "root";
        String PASSWORD = "2006@Puneet";
        // Establishing Connection.
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)){
            System.out.println("Database connected Successfully!");

            // Creating Statement.
            Statement statement = connection.createStatement();

            // Execute Query
            String sql = "SELECT * FROM employees";
            ResultSet rs = statement.executeQuery(sql);

            // Process the data
            while (rs.next()){
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getInt(5));
            }

            // Close Resources.
            connection.close();
            statement.close();
            rs.close();

        }catch (SQLException e){
            System.err.println("Database connection failed");
            e.printStackTrace();
        }
    }
}

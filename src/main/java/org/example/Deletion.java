package org.example;

import java.sql.*;

public class Deletion {
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
            String sql = "DELETE FROM employees where employee_id = 1";
            int rowAffected = statement.executeUpdate(sql);
            if (rowAffected == 0){
                System.out.println("The row is not affected and the data is same");
            }else
                System.out.println("Deletion is Completed!");

            // Close Resources.
            connection.close();
            statement.close();

        }catch (SQLException e){
            System.err.println("Database connection failed");
            e.printStackTrace();
        }
    }
}

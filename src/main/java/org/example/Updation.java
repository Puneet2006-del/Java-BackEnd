package org.example;

import java.sql.*;
import java.util.Scanner;

public class Updation {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/company_db";
        String USER = "root";
        String PASSWORD = "2006@Puneet";
        PreparedStatement statement;

        // Establishing Connection.
        try(Connection connection = DriverManager.getConnection(URL,USER,PASSWORD)) {
            System.out.println("Database connected Successfully!");

            // Execute Query
            String sql = "UPDATE employees set department = ? where employee_id = ?";

            // Creating Statement.
            statement = connection.prepareStatement(sql);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Enter the information that needs to be updated!");
            System.out.print("Enter the Department Name: ");
            String department = scanner.next();
            System.out.print("Enter the Employee_Id: ");
            int emp_id = scanner.nextInt();

            statement.setString(1,department);
            statement.setInt(2,emp_id);

            int rowAffected = statement.executeUpdate();
            if (rowAffected == 0) {
                System.out.println("Updating Failed");
            } else
                System.out.println("Database is updated");

            // Close Resources.
            connection.close();
            statement.close();

        }catch (SQLException e){
            System.err.println("Database connection failed");
            e.printStackTrace();
        }
    }
}

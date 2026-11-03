package org.example;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {

    private static final String URL =
            "jdbc:mysql://localhost:3306/company_db";

    private static final String USER = "root";

    private static final String PASSWORD = "2006@Puneet";

    public static void main(String[] args) {

        String sql = """
                INSERT INTO employees
                    (employee_id, name, email, department, salary)
                VALUES (?, ?, ?, ?, ?)
                """;

        try (Connection connection =
                     DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            System.out.println("Enter the following details as to be in Database: ");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the Employee Id: ");
            Integer emp_id = sc.nextInt();
            System.out.print("Enter the name: ");
            String name = sc.next();
            System.out.print("Enter the email: ");
            String email = sc.next();
            System.out.print("Enter the department: ");
            String department = sc.next();
            System.out.print("Enter the salary: ");
            BigDecimal salary = sc.nextBigDecimal();

            statement.setInt(1,emp_id);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, department);
            statement.setBigDecimal(
                    5,
                    new java.math.BigDecimal(String.valueOf(salary))
            );

            int rowsAffected = statement.executeUpdate();

            System.out.println(
                    "Rows inserted: " + rowsAffected
            );
            connection.close();
            statement.close();;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
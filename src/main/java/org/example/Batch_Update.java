package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;

public class Batch_Update {

    public static void main(String[] args) {

        String URL = "jdbc:mysql://localhost:3306/company_db";
        String Username = "root";
        String Password = "2006@Puneet";

        String sql = "INSERT INTO users " +
                "(employee_id, name, email, department, salary) " +
                "VALUES (?, ?, ?, ?, ?)";

        List<User> users = new ArrayList<>();

        users.add(new User(101, "Rahul", "rahul@gmail.com", "IT", 50000));
        users.add(new User(102, "Aman", "aman@gmail.com", "HR", 40000));
        users.add(new User(103, "Rohit", "rohit@gmail.com", "Finance", 45000));

        try (Connection conn = DriverManager.getConnection(URL, Username, Password);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            try {

                for (User u : users) {

                    ps.setInt(1, u.getemployee_id());
                    ps.setString(2, u.getname());
                    ps.setString(3, u.getemail());
                    ps.setString(4, u.getdepartment());
                    ps.setInt(5, u.getsalary());

                    ps.addBatch();
                }

                ps.executeBatch();

                conn.commit();

                System.out.println("Batch insertion successful!");

            } catch (SQLException e) {

                conn.rollback();

                System.out.println("Transaction rolled back!");
                e.printStackTrace();
            }

        } catch (SQLException e) {

            System.err.println("Database connection failed");
            e.printStackTrace();
        }
    }
}
package org.example;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bookstore";
        String username = "root";
        String password = "password";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Insert a book
            String insertSQL = "INSERT INTO books (title, author) VALUES (?, ?)";
            PreparedStatement insertStmt = connection.prepareStatement(insertSQL);
            insertStmt.setString(1, "Spring Boot in Action");
            insertStmt.setString(2, "Craig Walls");
            insertStmt.executeUpdate();

            // Retrieve all books
            String querySQL = "SELECT * FROM books";
            Statement queryStmt = connection.createStatement();
            ResultSet rs = queryStmt.executeQuery(querySQL);
            while (rs.next()) {
                System.out.println("Book: " + rs.getString("title") + " by " + rs.getString("author"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

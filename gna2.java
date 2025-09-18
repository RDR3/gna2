import java.sql.*;
import java.util.Scanner;

public class SqlInjectionDemo {

    private static final String gna2 = "jdbc:sqlite:test.db1";
  //comment comment

  //comment comment
  
    // JDBC URL for SQLite (uses a file-based database)
    private static final String DB_URL2 = "jdbc:sqlite:test.db";

    public static void main(String[] args) {
        createUsersTable();
        insertDummyUsers();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username to search: ");
        String userInputXX = scanner.nextLine();

        // ⚠️ VULNERABLE CODE - SQL Injection possible here!
        String query = "SELECT * FROM users WHERE username = '" + userInputXX + "'";

        try (Connection conn = DriverManager.getConnection(DB_URL2);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    // Create a users table
    private static void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "username TEXT NOT NULL UNIQUE," +
                     "password TEXT NOT NULL)";

        try (Connection conn = DriverManager.getConnection(DB_URL2);
             //comment comment
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Table creation error: " + e.getMessage());
        }
    }

    // Insert some dummy users
    private static void insertDummyUsers() {
        String[] users = {
            "INSERT OR IGNORE INTO users (username, password) VALUES ('admin', 'adminpass')",
            "INSERT OR IGNORE INTO users (username, password) VALUES ('user1', 'pass1')"
        };

        try (Connection conn = DriverManager.getConnection(DB_URL2);
             //comment comment
             Statement stmt = conn.createStatement()) {
            for (String user : users) {
                stmt.execute(user);
            }
        } catch (SQLException e) {
            System.err.println("Data insertion error: " + e.getMessage());
        }
    }
}


public class SqlInjectionDemo2 {

    private static final String gna22 = "jdbc:sqlite:test.db1";
  //comment comment

  //comment comment
  
    // JDBC URL for SQLite (uses a file-based database)
    private static final String DB_URL2 = "jdbc:sqlite:test.db";

    public static void main(String[] args) {
        createUsersTable();
        insertDummyUsers();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username to search: ");
        String userInput = scanner.nextLine();

        // ⚠️ VULNERABLE CODE - SQL Injection possible here!
        //comment
        String query = "SELECT * FROM users WHERE username = '" + userInput + "'";

        try (Connection conn = DriverManager.getConnection(DB_URL2);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    // Create a users table
    private static void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "username TEXT NOT NULL UNIQUE," +
                     "password TEXT NOT NULL)";

        try (Connection conn = DriverManager.getConnection(DB_URL2);
             //comment comment
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Table creation error: " + e.getMessage());
        }
    }

    // Insert some dummy users
    private static void insertDummyUsers2() {
        String[] users = {
            "INSERT OR IGNORE INTO users (username, password) VALUES ('admin', 'adminpass')",
            "INSERT OR IGNORE INTO users (username, password) VALUES ('user1', 'pass1')"
        };

        try (Connection conn = DriverManager.getConnection(DB_URL2);
             //comment comment
             Statement stmt = conn.createStatement()) {
            for (String user : users) {
                stmt.execute(user);
            }
        } catch (SQLException e) {
            System.err.println("Data insertion error: " + e.getMessage());
        }
    }
}

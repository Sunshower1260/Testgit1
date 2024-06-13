import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLServerConnection {
    private static final String SQL_SERVER_URL = "jdbc:sqlserver://MSI:1433;databaseName=loginTest;user=sa;password=123;";

    public static void main(String[] args) {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            try (Connection connection = DriverManager.getConnection(SQL_SERVER_URL)) {

                String query = "SELECT * FROM your_table_name";
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    try (ResultSet resultSet = statement.executeQuery()) {

                        while (resultSet.next()) {

                            System.out.println("Column 1 value: " + resultSet.getString(1));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("SQL Server JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connecting to SQL Server.");
            e.printStackTrace();
        }
    }
}
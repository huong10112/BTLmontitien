package BTL.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private Connection connection;
    
    private DBConnection() {
        try {
        	String url = "jdbc:sqlserver://localhost\\SQLEXPRESS02;databaseName=BTL;encrypt=true;trustServerCertificate=true";
        	String username = "mochi";
        	String password = "123456";

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Kết nối database thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Kết nối database thất bại!");
        }
    }
    
    public static synchronized DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connection;
    }
    
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                instance = null;
                System.out.println("Đóng kết nối database thành công!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
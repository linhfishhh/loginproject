package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSql {
    public static Connection getConnection(){
        String url="jdbc:mysql://localhost:3306/casestudy";
        String user="root";
        String passwd="123@123a";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,user,passwd);
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }
}

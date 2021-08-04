package DAO;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ManageUser {
    static Connection connection = ConnectionSql.getConnection();
    static ArrayList<User> List= new ArrayList<User>();
    static{
        connection=ConnectionSql.getConnection();
    }
    public static User selectlogin(String username,String passwd) throws SQLException {
        String query = "SELECT * FROM casestudy.tbl_user where username='" + username + "' and passwd='" + passwd + "'";
        PreparedStatement ps = connection. (query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = Integer.parseInt(rs.getString("id"));
            String name = rs.getString("name");
            int age = Integer.parseInt(rs.getString("age"));
            String username1 = rs.getString("username");
            String passwd1 = rs.getString("passwd");
            String email = rs.getString("email");
            String address = rs.getString("address");
            return new User(id, name, age, username1, passwd1, email, address);
        }
        return null;
    }
    public static void insert(String username,String passwd,String email) throws SQLException {
        String query="INSERT INTO `casestudy`.`tbl_user` (`id`, `name`, `age`, `username`, `passwd`, `email`, `address`) VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setInt(1,0);
        ps.setString(2,null);
        ps.setInt(3,0);
        ps.setString(4,username);
        ps.setString(5,passwd);
        ps.setString(6,email);
        ps.setString(7,null);
        ps.execute();
    }
}

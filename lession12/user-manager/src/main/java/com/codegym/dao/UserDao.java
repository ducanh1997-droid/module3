package com.codegym.dao;

import com.codegym.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserDao implements IUserDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/demo?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345678";


    private static final String INSERT_USERS_SQL = "INSERT INTO users(name,email,country) VALUES(?,?,?)";
    private static final String SELECT_USER_BY_ID = "SELECT * FORM users WHERE id=?";
    private static final String SELECT_ALL_USERS = "SELECT * FORM users";

    private static final String DELETE_USERS_SQL = "DELETE FORM users WHERE id=?";

    private static final String UPDATE_USERS_SQL = "UPDATE users set name=?,email=?,country=? where id=?";


    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    @Override
    public void insertUser(User user) throws SQLException {

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }
}

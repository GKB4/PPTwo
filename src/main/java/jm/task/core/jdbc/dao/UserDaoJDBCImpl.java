package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static int userID = 1;
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS users (id INT, name VARCHAR(20) not null, lastname VARCHAR(20) not null, age INT not null, PRIMARY KEY (id))";
        try {
            Util.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
    }

    public void dropUsersTable() {
        String query = "DROP TABLE users";
        try {
            Util.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "INSERT INTO users (id, name, lastname, age) VALUES (" + userID++ + ",'" + name + "', '" + lastName + "', " + Integer.valueOf(age) + ")";
        try {
            Util.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String query = "DELETE FROM users WHERE id = " + id;
        try {
            Util.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        String query = "SELECT * FROM users";
        List<User> users = new ArrayList<User>();

        try {
            ResultSet rs = Util.getStatement().executeQuery(query);
            while (rs.next()) {
                users.add(new User(rs.getString(2), rs.getString(3), (byte) rs.getInt(4)));
            }
            return users;
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }

        return null;
    }

    public void cleanUsersTable() {
        String query = "DELETE FROM users";
        try {
            Util.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }
    }
}

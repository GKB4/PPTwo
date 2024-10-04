package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/pptask2";
    private static final String user = "root";
    private static final String password = "123456";

    private static Connection connection;
    private static Statement statement;

    static {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
                statement = connection.createStatement();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Statement getStatement() {
        return statement;
    }
}

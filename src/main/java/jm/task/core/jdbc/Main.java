package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Igor", "Ilkov", (byte) 38);
        System.out.println("User с именем — Igor добавлен в базу данных");
        userDao.saveUser("Stepan", "Stepanov", (byte) 39);
        System.out.println("User с именем — Stepan добавлен в базу данных");
        userDao.saveUser("Sergey ", "Sergeev", (byte) 40);
        System.out.println("User с именем — Sergey добавлен в базу данных");
        userDao.saveUser("Petr ", "Petrov", (byte) 41);
        System.out.println("User с именем — Petr добавлен в базу данных");
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}

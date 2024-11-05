package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void deleteUser(int id);
}

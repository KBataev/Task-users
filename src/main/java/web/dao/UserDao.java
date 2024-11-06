package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    void deleteUser(int id);
    void addUser(User user);
    void updateUser(User user);
    User getUserById(int id);
}

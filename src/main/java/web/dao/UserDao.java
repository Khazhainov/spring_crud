package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> listUsers();
    User add(User user);
    User getById(Long id);
    void deleteById(Long id);
}

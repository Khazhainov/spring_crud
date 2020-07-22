package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> listUsers() {
        return userDao.listUsers();
    }

    public User add(User user) {
        return userDao.add(user);
    }

    public User getById(Long id) {
        return userDao.getById(id);
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}

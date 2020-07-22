package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> listUsers() {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public User add(User user) {
        if (user.getId() == null) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    public User getById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public void deleteById(Long id) {
        em.remove(getById(id));
    }
}

package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @Override
    @Transactional
    public void deleteUser(int id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.remove(user);
        }
    }

    @PersistenceContext
    private EntityManager em;

    public List<User> getUsers() {

        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

}

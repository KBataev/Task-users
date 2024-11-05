package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {


    @PersistenceContext
    private EntityManager em;

    public List<User> getUsers() {
        // Пример запроса
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

}

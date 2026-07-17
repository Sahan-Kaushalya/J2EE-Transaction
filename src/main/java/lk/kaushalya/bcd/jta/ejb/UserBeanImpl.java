package lk.kaushalya.bcd.jta.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lk.kaushalya.bcd.jta.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Stateless
public class UserBeanImpl implements UserBean {

    @PersistenceContext(unitName = "JTA-PU")
    private EntityManager em;

    @Override
    public boolean login(String email, String password) {
        return false;
    }

    @Override
    public boolean register(String name, String email, String address, String password) {

        if(name == null || email == null || address == null || password == null){
            return false;
        }

//        Session session = em.unwrap(Session.class);
//        Transaction transaction = session.beginTransaction();

//        em.getTransaction().begin();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        user.setPassword(password);
//
//        em.persist(user);
//        em.getTransaction().commit();

        em.persist(user);

//        session.persist(user);
//        transaction.commit();
        return true;
    }
}
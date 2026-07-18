package lk.kaushalya.bcd.jta.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;
import lk.kaushalya.bcd.jta.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserBeanImpl implements UserBean {

    @PersistenceContext(unitName = "JTA-PU")
    private EntityManager em;
//
//    @Resource
//    private UserTransaction tr;

    @EJB
    private AccountBean accountBean;

    @Override
    public boolean login(String email, String password) {
        return false;
    }


    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public boolean register(String name, String email, String address, String password) {

        if(name == null || email == null || address == null || password == null){
            return false;
        }

//        Session session = em.unwrap(Session.class);
//        Transaction transaction = session.beginTransaction();

//        em.getTransaction().begin();

//        try{
//            tr.begin();
//        }catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setAddress(address);
        user.setPassword(password);
//
//        em.persist(user);
//        em.getTransaction().commit();

        em.persist(user);
//        try{
//            tr.commit();
//        }catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }

//        session.persist(user);
//        transaction.commit();
        return true;
    }

    @Override
    public void transfer(Long fromAccountNo, Long toAccountNo, BigDecimal amount) {
      accountBean.debitAmount(fromAccountNo, amount);
      accountBean.creditAmount(toAccountNo, amount);
    }
}
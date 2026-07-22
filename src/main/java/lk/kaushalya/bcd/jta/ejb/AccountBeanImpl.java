package lk.kaushalya.bcd.jta.ejb;

import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import lk.kaushalya.bcd.jta.entity.Account;

import java.math.BigDecimal;

@Stateless
public class AccountBeanImpl implements AccountBean{

    @PersistenceContext(unitName = "JTA-PU")
    private EntityManager em;

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void creditAmount(Long accountNo, BigDecimal amount) {
        EntityTransaction transaction = em.getTransaction();
        System.out.println("creditAmount() called :"+System.identityHashCode(transaction));

        try {
            Account account =  em.createNamedQuery("Account.findByAccountNo", Account.class)
                      .setParameter("accountNo", accountNo)
                      .getSingleResult();

            account.setBalance(account.getBalance().add(amount));
            em.merge(account);

        } catch (NoResultException e) {
            e.printStackTrace();
        }

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void debitAmount(Long accountNo, BigDecimal amount) {
        EntityTransaction transaction = em.getTransaction();
        System.out.println("debitAmount() called :"+System.identityHashCode(transaction));

        try {
            Account account =  em.createNamedQuery("Account.findByAccountNo", Account.class)
                    .setParameter("accountNo", accountNo)
                    .getSingleResult();

            account.setBalance(account.getBalance().subtract(amount));
            em.merge(account);

        } catch (NoResultException e) {
            e.printStackTrace();
        }
    }
}
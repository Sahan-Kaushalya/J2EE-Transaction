package lk.kaushalya.bcd.jta.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import lk.kaushalya.bcd.jta.entity.Account;

import java.math.BigDecimal;

@Stateless
public class AccountBeanImpl implements AccountBean{

    @PersistenceContext(unitName = "JTA-PU")
    private EntityManager em;

    @Override
    public void creditAmount(Long accountNo, BigDecimal amount) {

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
    public void debitAmount(Long accountNo, BigDecimal amount) {
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
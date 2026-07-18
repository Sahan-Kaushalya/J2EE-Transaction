package lk.kaushalya.bcd.jta.ejb;

import jakarta.ejb.Local;
import jakarta.ejb.Remote;

import java.math.BigDecimal;

@Remote
public interface AccountBean {
    void creditAmount(Long accountNo, BigDecimal amount);
    void debitAmount(Long accountNo, BigDecimal amount);

}

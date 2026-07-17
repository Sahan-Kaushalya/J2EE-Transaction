package lk.kaushalya.bcd.jta.ejb;

import jakarta.ejb.Local;

@Local
public interface UserBean {
    boolean login(String email, String password);
    boolean register(String name, String email, String address, String password);
}

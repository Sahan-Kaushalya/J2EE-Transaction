package lk.kaushalya.bcd.jta.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.kaushalya.bcd.jta.ejb.UserBean;

import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/test-bank")
public class BankTest extends HttpServlet {

    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long fromAccount = Long.parseLong(req.getParameter("fromAccount"));
        Long toAccount = Long.parseLong(req.getParameter("toAccount"));
        BigDecimal amount = new BigDecimal(req.getParameter("amount"));

        userBean.transfer(fromAccount, toAccount, amount);
    }
}

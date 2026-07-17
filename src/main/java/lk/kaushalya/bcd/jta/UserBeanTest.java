package lk.kaushalya.bcd.jta;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.kaushalya.bcd.jta.ejb.UserBean;

import java.io.IOException;

@WebServlet("/test-register")
public class UserBeanTest extends HttpServlet {
    @EJB
    private UserBean userBean;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        boolean result = userBean.register("Sahan","sahan@gmail.com","Kirindiwela","S1234");

        if(result){
            resp.getWriter().write("Registration successful");
        }else {
            resp.getWriter().write("Registration failed");
        }
    }
}

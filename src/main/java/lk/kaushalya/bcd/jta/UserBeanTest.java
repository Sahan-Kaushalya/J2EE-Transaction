package lk.kaushalya.bcd.jta;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.kaushalya.bcd.jta.ejb.UserBean;

import java.io.IOException;
import java.util.Random;

@WebServlet("/test-register")
public class UserBeanTest extends HttpServlet {
    @EJB
    private UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        if (username != null) {

            String[] addresses = {"Kirindiwela", "Colombo", "Kandy", "Gampaha", "Galle", "Kurunegala"};
            Random random = new Random();
            int randomIndex = random.nextInt(addresses.length);
            String randomAddress = addresses[randomIndex];

            boolean result = userBean.register(username,username.toLowerCase()+"@gmail.com",randomAddress,username.toUpperCase().charAt(0)+"1234");

            if(result){
                resp.getWriter().write("Registration successful");
            }else {
                resp.getWriter().write("Registration failed");
            }
        }else{
            resp.getWriter().write("Username is required");
        }
    }
}

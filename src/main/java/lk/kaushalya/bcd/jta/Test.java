package lk.kaushalya.bcd.jta;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class Test extends HttpServlet {

    @PersistenceContext(unitName = "JTA-PU")
    private EntityManager em;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /// When a user sends a request, create a new EntityManagerFactory for that request.
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JTA-PU");
//        System.out.println(emf.hashCode());
//        EntityManager em = emf.createEntityManager();

 //       EntityManager em = ManagerFactory.getEntityManager();

        List<Object> result = em.createNativeQuery("SELECT * FROM user").getResultList();
        req.setAttribute("yourDataAttribute", result);
        req.getRequestDispatcher("/test.jsp").forward(req, resp);
    }
}

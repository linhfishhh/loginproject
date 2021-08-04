package Controller;

import DAO.ManageUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/dangky"})
public class dangkyservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String username=req.getParameter("username");
        String email=req.getParameter("email");
        String passwd=req.getParameter("passwd");
        String confirmpasswd=req.getParameter("confirm-password");
        System.out.println(username+email+passwd+confirmpasswd);
        if(passwd.equals(confirmpasswd)){
            try {
                ManageUser.insert(username,passwd,email);
                resp.sendRedirect("/index.jsp");
            } catch (SQLException throwables) {
                resp.sendRedirect("/View/Dangky.jsp");
            }
        }
    }
}

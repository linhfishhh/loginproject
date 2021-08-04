package Controller;

import DAO.ManageUser;
import Models.User;
import com.sun.net.httpserver.Authenticator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/login"})
public class ServletUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String username=req.getParameter("username");
        String passwd=req.getParameter("passwd");
        System.out.println(username+":"+passwd);
        try {
            User user= ManageUser.selectlogin(username, passwd);
            if(username.equals(user.getUsername()) && passwd.equals(user.getPasswd())){
                resp.sendRedirect("/View/Adminpage.jsp");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }catch (NullPointerException e){
            req.setAttribute("False","Sai Username hoac passwd!");
            requestDispatcher=req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req,resp);
        }
    }
}

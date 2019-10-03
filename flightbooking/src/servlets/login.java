package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "login")
public class login extends HttpServlet {

        public void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            String n=request.getParameter("username");
            String p=request.getParameter("password");

            if(LoginDao.validate(n, p)){
                RequestDispatcher rd=request.getRequestDispatcher("Welcome.html");
                rd.forward(request,response);
            }
            else{
                out.print("Sorry username or password error");
                RequestDispatcher rd=request.getRequestDispatcher("register.html");
                rd.include(request,response);
            }

            out.close();
        }
    }

}

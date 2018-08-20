package servlets;

import base.AccountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private final AccountServiceImplement accountServiceImplement;

    public SignInServlet(AccountServiceImplement accountServiceImplement) {
        this.accountServiceImplement = accountServiceImplement;
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        boolean loggedIn = accountServiceImplement.sighIn(login,password);
        response.setContentType("text/html; charset=utf-8");
        if (loggedIn){
            response.getWriter().print("Authorized: " + login);
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            response.getWriter().print("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}

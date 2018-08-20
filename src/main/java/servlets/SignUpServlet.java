package servlets;

import base.AccountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountServiceImplement accountServiceImplement;

    public SignUpServlet(AccountServiceImplement accountServiceImplement) {
        this.accountServiceImplement = accountServiceImplement;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        accountServiceImplement.signUp(login,password);

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("SignedUp");
        response.setStatus(HttpServletResponse.SC_OK);
    }

}

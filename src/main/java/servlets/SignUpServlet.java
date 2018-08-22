package servlets;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpServlet extends HttpServlet {
    private final AccountServiceImplement accountServiceImplement;

    public SignUpServlet(AccountServiceImplement accountServiceImplement) {
        this.accountServiceImplement = accountServiceImplement;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            accountServiceImplement.signUp(login,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("SignedUp");
        response.setStatus(HttpServletResponse.SC_OK);
    }

}

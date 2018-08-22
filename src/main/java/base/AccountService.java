package base;

import java.sql.SQLException;

public interface AccountService {
    public boolean sighIn(String login, String password) throws SQLException;
    public void signUp(String login, String password) throws SQLException;
}

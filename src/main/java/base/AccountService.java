package base;

public interface AccountService {
    public boolean sighIn(String login, String password);
    public void signUp(String login, String password);
}

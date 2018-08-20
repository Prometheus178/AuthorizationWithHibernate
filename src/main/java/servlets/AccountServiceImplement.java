package servlets;

import base.AccountService;
import base.UserProfile;

import java.util.HashMap;
import java.util.Map;

public class AccountServiceImplement implements AccountService {

    private final Map<String, UserProfile> signedUpUsers = new HashMap<String, UserProfile>();

    public boolean sighIn(String login, String password) {
        UserProfile profile = signedUpUsers.get(login);
        return  (profile != null && profile.getPassword().equals(password));

    }

    public void signUp(String login, String password) {
        signedUpUsers.put(login, new UserProfile(login,password));
    }

}

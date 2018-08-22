package servlets;

import base.AccountService;
import base.DBService;
import base.UserProfile;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AccountServiceImplement implements AccountService {

    private final DBService dbService;

    public AccountServiceImplement(DBService dbService) {
        this.dbService = dbService;
    }

    public boolean sighIn(String login, String password){
        try {
            UserProfile profile = dbService.getUser(login);
            return  (profile != null && profile.getPassword().equals(password));
        } catch (SQLException e){
            System.out.println("Can't sing in: " + e.getMessage());
            return false;
        }


    }

    public void signUp(String login, String password) throws SQLException {
        dbService.addUser(new UserProfile(login,password));
    }

}

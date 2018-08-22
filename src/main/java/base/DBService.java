package base;

import dbService.dataSets.UsersDataSet;

import java.sql.SQLException;

public interface DBService {
    void create() throws SQLException;
    long addUser(UserProfile userProfile) throws SQLException;
    UserProfile getUser(String login) throws SQLException;
    void clean() throws SQLException;
    void check() throws SQLException;



}

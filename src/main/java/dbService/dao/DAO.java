package dbService.dao;

import base.UserProfile;
import dbService.dataSets.UsersDataSet;

import java.sql.SQLException;

public interface DAO {
    public UsersDataSet get(String login)throws SQLException;
    public long getUserId(String login)throws SQLException;
    public int getUsersCount()throws SQLException;
    public void insertUser(UserProfile profile)throws SQLException;
    public void createTable()throws SQLException;
    public void clean()throws SQLException;
}

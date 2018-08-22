package dbService;

import base.DBService;
import base.UserProfile;
import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;
import org.h2.jdbcx.JdbcDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBServiceImplements implements DBService {

    private final Connection connection;

    public DBServiceImplements() {
        this.connection = getH2dbConnection();
    }

    @Override
    public void create() throws SQLException {
        new UsersDAO(connection).createTable();
    }

    @Override
    public long addUser(UserProfile userProfile) throws SQLException {
        try {
            connection.setAutoCommit(false);
            UsersDAO dao = new UsersDAO(connection);
            dao.insertUser(userProfile);
            connection.commit();
            return dao.getUserId(userProfile.getLogin());
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
            }
            throw new SQLException(e);
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ignore) {
            }
        }
    }

    @Override
    public UserProfile getUser(String login) throws SQLException {
        UsersDAO dao = new UsersDAO(connection);
        UsersDataSet dataSet = dao.get(login);
        return new UserProfile(dataSet.getLogin(),dataSet.getPassword());
    }

    @Override
    public void clean() throws SQLException {
        UsersDAO dao = new UsersDAO(connection);
        dao.clean();
    }

    @Override
    public void check() throws SQLException {
        System.out.println("Driver name: " + connection.getMetaData().getDriverName());
        System.out.println("Driver version: " + connection.getMetaData().getDriverVersion());

        UsersDAO dao = new UsersDAO(connection);
        int count = dao.getUsersCount();
        System.out.println("Count of records in users: " + count);
    }

    private static Connection getH2dbConnection(){
        try {
            String url = "jdbc:h2:./h2db";
            String name = "admin";
            String pass = "admin";

            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL(url);
            ds.setUser(name);
            ds.setPassword(pass);

            Connection connection = DriverManager.getConnection(url, name, pass);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

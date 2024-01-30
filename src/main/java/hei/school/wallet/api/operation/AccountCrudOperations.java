package hei.school.wallet.api.operation;

import hei.school.wallet.api.db.DBConnection;
import hei.school.wallet.api.db.entity.Account;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountCrudOperations implements CrudOperations<Account> {
    @Override
    public List<Account> findAll() {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            String sqlQuery = "select * from account";
            rs = statement.executeQuery(sqlQuery);
            List<Account> accountList = new ArrayList<>();
            while (rs.next()) {
                Account account = new Account(
                        rs.getString("id"),
                        rs.getString("name"));
                accountList.add(account);
            }
            return accountList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Account findById(String id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        try {
            connection = DBConnection.getConnection();
            statement = connection.createStatement();
            String sqlQuery = "select * from account where id = '" + id + "'";
            rs = statement.executeQuery(sqlQuery);
            while (rs.next()) {
                return new Account(rs.getString("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return null;
    }
}

package ru.edu.jborn.dao;

import ru.edu.jborn.dao.domain.Account;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static ru.edu.jborn.dao.FactoryDao.getConnection;

public class AccountDaoImp implements Dao<Account,Integer>{

    private final String GET_ACCOUNT =
            "select * " +
            "from account " +
            "where user_id = ?";


    @Override
    public List<Account> findById(Integer user_id) throws SQLException {
        List<Account> list = new ArrayList<>();

        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(GET_ACCOUNT);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                BigDecimal balance = rs.getBigDecimal("balance");
                String name = rs.getString("name");
                Account account = new Account(id, user_id, balance, name);
                list.add(account);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Account> findByAll() {
        return null;
    }

    @Override
    public Account insert(Account account) {
        return null;
    }

    @Override
    public Account update(Account account) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

}

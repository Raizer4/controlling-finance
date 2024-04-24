package ru.edu.jborn.dao;

import ru.edu.jborn.dao.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static ru.edu.jborn.dao.FactoryDao.getConnection;

public class UserDaoImp implements Dao<User,Integer>{

    private static UserDaoImp userDaoImp;

    public static UserDaoImp getUserDaoImp() {

        if (userDaoImp == null){
            userDaoImp = new UserDaoImp();
        }

        return userDaoImp;
    }

    private UserDaoImp(){}

    private final String LOGIN =
            "select * " +
            "from users u " +
            "where name = ? and password = ?";

    private final String REGISTER =
            "insert into users(name, password, email) values (?,?,?)";

    public Integer authorization(String name, String password) throws SQLException {

        Integer id = null;

        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(LOGIN);
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
        }

        return id;

    }

    public void registration(String name,String password,String email) throws SQLException {

        Integer id = null;

        try (Connection connection = getConnection()) {
            PreparedStatement ps = connection.prepareStatement(REGISTER);
            ps.setString(1, name);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.executeUpdate();

            ResultSet gkRs = ps.getGeneratedKeys();

            if (gkRs.next()){
                id = gkRs.getInt(1);
            }

        }


    }

    @Override
    public List<User> findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByAll() {
        return null;
    }

    @Override
    public User insert(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

}

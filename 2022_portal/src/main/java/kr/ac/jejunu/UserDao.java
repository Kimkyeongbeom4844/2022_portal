package kr.ac.jejunu;

import java.sql.*;

public class UserDao {
    private final jdbcContext jdbcContext;

    public UserDao(jdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User findById(Integer id) throws SQLException {
        String sql = "select * from userinfo where id = ?";
        Object[] params = new Object[] {id};
        return jdbcContext.find(sql, params);
    }

    public void insert(User user) throws SQLException {
        String sql = "insert into userinfo(name, password) values ( ?, ? )";
        Object[] params = new Object[] {user.getName(),user.getPassword()};
        jdbcContext.insert(user, sql, params, this);
    }

    public void update(User user) throws SQLException {
        String sql = "update userinfo set name = ?, password = ? where id = ?";
        Object[] params = new Object[] {user.getName(),user.getPassword(),user.getId()};
        jdbcContext.update(sql, params);
    }

    public void delete(Integer id) throws SQLException {
        String sql = "delete from userinfo where id = ?";
        Object[] params = new Object[] {id};
        UserDao.this.jdbcContext.update(sql, params);
    }

//    public PreparedStatement makeStatement(Integer id, Connection connection) throws SQLException {
//        PreparedStatement preparedStatement;
//        preparedStatement = connection.prepareStatement(
//                "delete from userinfo where id = ?"
//        );
//        preparedStatement.setInt(1, id);
//        return preparedStatement;
//    }
}
package com.larry.dao;

import com.larry.domain.Book;
import com.larry.domain.User;
import com.larry.util.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    private QueryRunner qr = new QueryRunner();

    public User queryByUsername(String username) {
        String sql =
                "select * from user where username=?";

        Connection conn = JdbcUtil.getConnection();
//        System.out.println(conn);

        User user = new User();
        try {
          user = qr.query(conn, sql, new BeanHandler<User>(User.class), username);
//            System.out.println(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public void insert(User user) {
        String sql =
                "insert into user values(null,?,?)";
        Connection conn = JdbcUtil.getConnection();
        try {
            qr.update(conn,sql,user.getUsername(),user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询books
    public Book queryByBookname(String bookName){

        return null;
    }

    public List<Book> queryAllBook(){
        String sql =
                "select * from book";
        Connection connection = JdbcUtil.getConnection();
        List<Book> bookList = null;
        try {
            bookList = qr.query(connection, sql, new BeanListHandler<Book>(Book.class));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }
}

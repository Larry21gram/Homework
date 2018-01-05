package com.mysql;

import com.bean.User;
import net.sf.json.JSONArray;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class Database {
//        操作数据库
    public static JSONArray select() throws SQLException {
        /**
         * 访问数据库,获取所有信息
         */
        List<User> users = new MyQuery().query(Jdbc.getConn(),
                "select * from user",
                new BeanListHandler<User>(User.class));
        JSONArray jsonArray = JSONArray.fromObject(users);
        return jsonArray;
    }

    public static int add(String username,String gender) throws SQLException {
    /**
     * 访问数据库,添加信息
     */
        int i = new MyQuery().update(Jdbc.getConn(),
                "insert into user values(null,?,?)",
                username, gender
        );
        return i;
    }
}

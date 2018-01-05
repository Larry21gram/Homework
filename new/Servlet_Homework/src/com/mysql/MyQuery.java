package com.mysql;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class MyQuery extends QueryRunner{
//    查询
    @Override
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh) throws SQLException {
        //设置手动提交
        conn.setAutoCommit(false);
        T t = super.query(conn,sql,rsh);
        // 提交事物
        conn.commit();
        conn.close();
        return t;
    }

    //修改
    @Override
    public int update(Connection conn, String sql, Object... params) throws SQLException {
        conn.setAutoCommit(false);
        int t = super.update(conn, sql, params);
        conn.commit();
        conn.close();
        return t;
    }
}

package com.ll.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author liulu
 * @create 2019-12-18 10:39
 */

public class DBUtils {
    private Connection conn;

    public DBUtils() {

    }

    /**
     * 获取数据库的连接
     *
     * @return conn
     */
    public Connection getConnection(String url, String user, String psw) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        if (null == conn) {
            try {
                conn = DriverManager.getConnection(url, user, psw);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return conn;
    }

    /**
     * 释放资源
     *
     * @param conn
     * @param stmt
     * @param rs
     */
    public void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                if (null != stmt) {
                    try {
                        stmt.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    } finally {
                        if (null != conn) {
                            try {
                                conn.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        }
    }
}

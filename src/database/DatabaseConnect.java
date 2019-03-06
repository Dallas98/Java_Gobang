package database;

import javax.swing.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: Java五子棋
 * @description:
 * @author: 阳鹏
 * @create: 2018-12-14 13:08
 */
public class DatabaseConnect {
    private static Connection conn = null;

    public static Connection getConnect() {
        try {
            String url = "jdbc:sqlserver://localhost:1433;DatabaseName=account;";
            String user = "sa";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.out.println("数据库连接失败");
        }
        return conn;
    }
}



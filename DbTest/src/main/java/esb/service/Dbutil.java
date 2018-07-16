package esb.service;

import java.sql.*;

public class Dbutil {
    /*
     * 功能：编写一个静态方法用于与数据库建立连接 输入参数：无 返回值：数据库连接对象
     */
    public static Connection getConnection() {
// 定义一个连接对象
        Connection conn = null;
// 创建预编译语句对象，一般都是用这个而不用Statement
        PreparedStatement pre = null;
// 创建一个结果集对象
        ResultSet result = null;
// 定义连接数据库的URL资源

        String url = "jdbc:oracle:thin:@10.7.21.240:1521:esb";
// 定义连接数据库的用户名称与密码
        String username = "sgss";
        String password = "sgss";
// 加载数据库连接驱动
        String className = "oracle.jdbc.driver.OracleDriver";
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
// 获取数据库的连接对象
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接建立成功...");
        } catch (SQLException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
// 返回连接对象
        return conn;
    }

    public static void close(Connection c) {
        if (c != null) {
            try {
                c.close();
            } catch (Throwable e) {

                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement c) {
        if (c != null) {
            try {
                c.close();
            } catch (Throwable e) {

                e.printStackTrace();
            }
        }
    }
}

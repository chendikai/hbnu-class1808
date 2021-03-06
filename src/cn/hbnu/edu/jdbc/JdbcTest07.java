package cn.hbnu.edu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 使用PreparedStatement实现数据的增、删、改
 *
 * @author 陈迪凯
 * @date 2020-10-28 10:05
 */
public class JdbcTest07 {
    public static void main(String[] args) {
        // 从配置文件读取数据库信息
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String user = resourceBundle.getString("user");
        String password = resourceBundle.getString("password");

        // 声明变量
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1、注册驱动
            Class.forName(driver);

            // 2、获取连接
            conn = DriverManager.getConnection(url, user, password);

            // 3、获取数据库操作对象
            // String sql = "insert into userinfo(username, password, realname, salary) values(?, ?, ?, ?)"; // 新增数据
            // String sql = "update userinfo set salary = ? where username = ?"; // 更新数据
            String sql = "delete from userinfo where username = ?"; // 删除数据
            ps = conn.prepareStatement(sql);

            // 4、执行SQL语句
            /*
            // 新增数据
            ps.setString(1, "xuzhu");
            ps.setString(2, "456789");
            ps.setString(3, "虚竹");
            ps.setDouble(4, 9999);
            */

            /*
            // 更新数据
            ps.setDouble(1, 200);
            ps.setString(2, "xuzhu");
            */

            // 删除数据
            ps.setString(1, "GAI");

            int count = ps.executeUpdate();
            System.out.println("影响的数据量：" + count);

            // 5、处理查询结果集

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 6、释放资源
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

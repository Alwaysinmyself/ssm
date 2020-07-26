import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class jdbcUtil {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    //读取文件
    static {
        try{
            Properties properties = new Properties();
            ClassLoader classLoader = jdbcUtil.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            System.out.println(path);
            //加载文件
            properties.load(new FileReader(path));
            //获取数值
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");
            Class.forName(driver);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

    //获得连接
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    //关闭连接
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
       if(rs != null){
           try{
               rs.close();
           }catch (SQLException e){
               e.printStackTrace();
           }
       }
        if(stmt != null){
            try{
                stmt.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        if(conn != null){
            try{
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}

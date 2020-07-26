import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc_test {

//    //主函数，程序的入口
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入用户名");
//        String username = sc.nextLine();
//        System.out.println("请输入密码");
//        String password = sc.nextLine();
//
//        boolean loginFlag = new jdbc_test().login(username, password);
//        if(loginFlag){
//            System.out.println("登录成功");
//        }else {
//            System.out.println("登陆失败");
//        }
//    }

    public boolean login(String username, String password){
        if(username==null || password==null){
            return false;
        }
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            conn = jdbcUtil.getConnection();
            String sql = "select * from user where username = '"+username+"'and password = '"+password+"'";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            return rs.next();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            jdbcUtil.close(rs, stmt, conn);
        }
        return false;
    }
}

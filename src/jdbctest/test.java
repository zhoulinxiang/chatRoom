package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by 178386610qqcom on 15/4/19.
 */
public class test {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/chat";
    static final String USER = "root";
    static final String PASS = "root";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn =  DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "select * from user";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getInt("id")+rs.getString("username"));
            }

        } catch (Exception e) {
            System.out.println("wrong!");
        }
    }
}

package chat.server.util;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by 178386610qqcom on 15/4/19.
 */
public class database {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/chat";
    static final String USER = "root";
    static final String PASS = "root";

    public String logIn(user user) throws Exception {

        Connection conn = null;
        Statement stmt = null;
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        System.out.println("mysql:");
        String sql = "select * from user where username = " +"\""+user.getName()+"\"";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        //System.out.println(rs.toString());
        user userResult=null;
        while (rs.next()) {
            //System.out.println(rs.getInt("id") + rs.getString("username")+rs.getString("nickname"));
            userResult= new user();
            //String tmp =rs.getString("nickname");
            //System.out.println("tmp:"+tmp);
            userResult.setNickname(rs.getString("nickname"));

        }
        conn.close();
        //System.out.println("user nickname :"+userResult.getNickname());
        if (userResult==null)
            return "";
        return userResult.getNickname();
    }
    public boolean signUp(user user) throws Exception{
        Connection conn = null;
        Statement stmt = null;
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        stmt = conn.createStatement();
        System.out.println("mysql:");
        String sql="Insert into user(username,password,nickname) values (\""+user.name+"\",\""+user.password+"\",\""+user.nickname+"\");";
        System.out.println(sql);
        int count = stmt.executeUpdate(sql);
        System.out.println("count:"+count);
        conn.close();
        if (count>=1)
            return true;
        return false;
    }
}

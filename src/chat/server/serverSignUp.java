package chat.server;

import chat.server.util.database;
import chat.server.util.user;
import com.sun.tools.classfile.Synthetic_attribute;
import jdk.management.cmm.SystemResourcePressureMXBean;

import javax.sound.midi.Soundbank;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 178386610qqcom on 15/4/19.
 */
public class serverSignUp {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9997);
        while(true){
            Socket client = server.accept();
            DataInputStream dis =new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            String msg =dis.readUTF();
            System.out.println(msg);
            System.out.println("index:"+msg.indexOf("|")+msg.indexOf("&"));
            String name =msg.substring(0,msg.indexOf("|"));
            String password=msg.substring(msg.indexOf("|")+1,msg.indexOf("&"));
            String nickname=msg.substring(msg.indexOf("&")+1,msg.length());
            System.out.println("name:" + name);
            System.out.println("password:" + password);
            System.out.println("nickname:" + nickname);
            user user=new user();
            user.setName(name);
            user.setPassword(password);
            user.setNickname(nickname);
            boolean yes = new database().signUp(user);
            System.out.println("yes:"+yes);
        }

    }
}

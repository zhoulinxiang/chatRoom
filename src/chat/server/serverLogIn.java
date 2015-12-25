package chat.server;

import chat.server.util.database;
import chat.server.util.user;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 178386610qqcom on 15/4/19.
 */
public class serverLogIn {
    public static void main(String[] args) throws Exception {
        try {
            new serverLogIn().start();
        } catch (Exception e) {
            //e.printStackTrace();
        }

    }
    public void start() throws Exception{
        ServerSocket server =new ServerSocket(9998);
        while(true){
            Socket client = server.accept();
            oneUser channel = new oneUser(client);
            new Thread(channel).start();
        }

    }
    private class oneUser implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;

        public oneUser(Socket client){
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private user isUser(String msg){
            boolean isuser = true;
            System.out.println("index:" + msg.indexOf('|'));
            String name = msg.substring(0,msg.indexOf('|'));
            String password = msg.substring(msg.indexOf('|')+1,msg.length());
            System.out.println("name:" + name + "psw:" + password);
            user user = new user();
            user.setName(name);
            user.setPassword(password);
            database dbs = new database();
            try {
                String userNickName = dbs.logIn(user);
                user.setNickname(userNickName);
                if (userNickName=="")
                    isuser=false;
            } catch (Exception e) {
                //e.printStackTrace();
            }
            //user.setNickname("");

            if (isuser==true)
                return user;
            return null;

        }
        @Override
        public void run() {
            String msg = "";
            try {
                msg=dis.readUTF();
                System.out.println("msg:"+msg);
                user user = isUser(msg);
                if (user==null){
                    dos.writeUTF("");
                    dos.flush();
                System.out.println(user.toString());
                }
                else{
                    System.out.println(user.getNickname());
                    dos.writeUTF(user.getNickname());
                    dos.flush();
                }

            } catch (IOException e) {
                //e.printStackTrace();
            }

        }
    }
}

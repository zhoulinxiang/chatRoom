package chat.server;

import chat02.closeUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by master on 2015/4/13.
 */
public class server {
    private List<Mychannel> all= new ArrayList<Mychannel>();

    public static void  main (String args[]) throws Exception {
        new server().start();


    }
    public void start() throws Exception{
        ServerSocket server =new ServerSocket(9999);
        while(true){
            Socket client = server.accept();
            System.out.println("建立起一个连接");
            Mychannel channel = new Mychannel(client);
            all.add(channel);
            new Thread(channel).start();
        }

    }
    private class Mychannel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private String name;
        private boolean isRunning=true;
        public Mychannel(Socket client){
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client .getOutputStream());
                this.name = dis.readUTF();
                this.send("欢迎你进入聊天室！");
                System.out.println(name);
                sendOthers(this.name+"进入了聊天室",true);
            } catch (IOException e) {
                //e.printStackTrace();
                closeUtil.closaAll(dis,dos);
                isRunning = false;

            }
        }
        private String receive (){
            String msg= "";
            try {
                msg = dis.readUTF();
                System.out.println("receive:"+msg);
            } catch (IOException e) {
                //e.printStackTrace();
                closeUtil.closaAll(dis);
                isRunning = false;
                all.remove(this);

            }
            return  msg;


        }
        private void send(String msg){
            if (null==msg||msg.equals("")){
                return ;
            }
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                closeUtil.closaAll(dos);
                isRunning = false;
                all.remove(this);

            }
        }
        private void sendOthers(String msg,boolean sys){
            //String msg = receive();
            if (msg.startsWith("@")&&msg.indexOf(" ")>1){
                String name = msg.substring(1,msg.indexOf(" "));
                String content = msg.substring(msg.indexOf(" ")+1);
                for (Mychannel other:all){
                    if (other.name.equals(name))
                        other.send(this.name+"悄悄对你说："+content);
                }

            }else {

                if (!sys) {
                    for (Mychannel other : all) {
                        other.send(this.name+":"+msg);
                    }
                } else {
                    for (Mychannel other : all) {
                        other.send("系统信息:"+msg);
                    }

                }
            }

        }
        @Override
        public void run() {
            while (isRunning){
                sendOthers(receive(),false);
            };

        }
    }
}

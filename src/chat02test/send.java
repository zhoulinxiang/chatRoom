package chat02;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by master on 2015/4/13.
 */
public class send implements Runnable {
    private BufferedReader console;
    private DataOutputStream dos ;
    private boolean isRuning =true;
    String name;


    public send(){
        console = new BufferedReader(new InputStreamReader(System.in));
    }
    public send(Socket client,String name){
        this();
        try {
            dos = new DataOutputStream(client.getOutputStream());
            this.name = name;
            send(this.name);
        } catch (IOException e) {
            //e.printStackTrace();
            isRuning = false;
            closeUtil.closaAll(dos,console);
        }
    }
    private String getMessage(){
        try {
            return console.readLine();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        return "";

    }
    public void send(String msg){
       // String msg=getMessage();
        try {
            if (null!=msg&&!msg.equals("")){
                dos.writeUTF(msg);
                dos.flush();
            }
        }
        catch (IOException e){
            isRuning = false;
            closeUtil.closaAll(dos,console);
        }
    }
    @Override
    public void run() {
        while (isRuning){
            send(getMessage());
        }

    }
}

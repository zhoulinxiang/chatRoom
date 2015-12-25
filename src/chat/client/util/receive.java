package chat.client.util;

import chat02.closeUtil;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by master on 2015/4/13.
 */
public class receive implements Runnable{
    private DataInputStream dis;
    private boolean isRunning = true;
    public receive(){

    }
    public receive(Socket client){
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isRunning = false;
            chat02.closeUtil.closaAll(dis);
        }
    }
    public String receive(){
        String msg = "";
        try {
                msg = dis.readUTF();
        }
        catch (IOException e){
            isRunning = false;
            closeUtil.closaAll(dis);
        }
        return msg;
    }

    @Override
    public void run() {
        while (isRunning){
            System.out.println(receive());
        }

    }
}

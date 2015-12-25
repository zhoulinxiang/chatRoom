package tcp.socket;

import java.io.DataInputStream;
import java.net.Socket;

/**
 * Created by master on 2015/4/10.
 */
public class client {

    public static void main(String args[]) throws Exception{
        Socket client = new Socket("localhost",8888);
        DataInputStream dis =new DataInputStream(client.getInputStream());
        String echo = dis.readUTF();
        System.out.println(echo);
    }



}

package chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by master on 2015/4/13.
 */
public class server {
    public static void  main (String args[]) throws IOException{
        ServerSocket server = new ServerSocket(9999);
        Socket client =server.accept();

        DataInputStream dis = new DataInputStream(client.getInputStream());


        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        while(true){
            String msg = dis.readUTF();
            dos.writeUTF("server: "+msg);
            dos.flush();

        }

    }
}

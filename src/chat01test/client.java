package chat01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by master on 2015/4/13.
 */
public class client{
    public static void  main (String args[]) throws Exception{
        Socket client = new Socket("localhost",9999);
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());
        while(true){
            String info = console.readLine();
            dos.writeUTF(info);
            dos.flush();
            String msg = dis.readUTF();
            System.out.println(msg);
        }
    }
}

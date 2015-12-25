package chat.client;

import chat.client.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by master on 2015/4/13.
 */
public class client {
    public static void  main (String args[]) throws Exception{
        System.out.println("Your name:");
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        Socket client = new Socket("localhost",9999);
        new Thread(new send(client,name)).start();
        new Thread(new receive(client)).start();
    }
}

package tcp.socket;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by master on 2015/4/10.
 */
public class server {
    public static void main(String args[])throws Exception{
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();//阻塞式
        System.out.println("a client link");
        String msg="Welcome you!";
        /*BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write(msg);
        bw.newLine();
        bw.flush();
        */
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();

    }
}

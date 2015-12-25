package ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * Created by master on 2015/4/9.
 */
public class ip2 {
    public static void  main(String args[]) throws Exception{
        InetSocketAddress addr = new InetSocketAddress("127.0.0.1",9999);
        System.out.println(addr.getHostName());
        System.out.println(addr.getPort());
        InetAddress address=addr.getAddress();
        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());

    }
}

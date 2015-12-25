package ip;

import java.net.InetAddress;

/**
 * Created by master on 2015/4/9.
 */
public class ip {
    public static void main(String args[])throws Exception{
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println(addr.getHostName());
        System.out.println(addr.getHostAddress());
        InetAddress addr2=InetAddress.getByName("www.baidu.com");
        System.out.println(addr2.getHostName());
        System.out.println(addr2.getHostAddress());
        InetAddress addr3=InetAddress.getByName("111.13.100.91");
        System.out.println(addr2.getHostName());
        System.out.println(addr2.getHostAddress());


    }
}

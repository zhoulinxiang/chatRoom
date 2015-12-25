package chat.client.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by master on 2015/4/13.
 */
public class closeUtil {
    public static void closaAll(Closeable... io){
        for(Closeable tmp:io){
            try {
                tmp.close();
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }
    }
}

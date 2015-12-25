package chat.client.ui;

import javax.swing.*;

/**
 * Created by 178386610qqcom on 15/4/18.
 */
public class swingConsole {
    public static  void run(final JFrame f,final int width,int height){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setTitle(f.getClass().getSimpleName());
                f.setSize(width, height);
                f.setVisible(true);
            }
        });
    }
}

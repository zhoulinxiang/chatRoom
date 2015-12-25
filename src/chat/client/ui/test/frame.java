package chat.client.ui.test;

import javax.swing.*;

/**
 * Created by 178386610qqcom on 15/4/19.
 */
public class frame extends JFrame {
    public frame(){
        JFrame j1=new frame1();
        j1.setVisible(false);
        JFrame j2=new frame2();
        add(j1);
        add(j2);
    }

    public static void main(String[] args) {
        new frame();
    }
}

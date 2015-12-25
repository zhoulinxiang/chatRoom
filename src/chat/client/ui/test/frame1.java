package chat.client.ui.test;

import javax.swing.*;

/**
 * Created by 178386610qqcom on 15/4/19.
 */
public class frame1 extends JFrame{
    public frame1(){
        JButton b= new JButton("laji ");
        JTextArea t = new JTextArea();
        setLayout(null);
        b.setBounds(0,0,50,50);
        t.setBounds(50,50,50,50);

        add(b);
        add(t);
        setSize(400,400);
        setVisible(true);

    }

    public static void main(String[] args) {
        new frame1();
    }
}

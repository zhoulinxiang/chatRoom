package chat.client.ui.test;

import chat.client.ui.chat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 178386610qqcom on 15/4/19.
 */
public class sb extends JFrame{
    static chat a=new chat("aa");

    JButton b =new JButton("dianji");
    public sb(){
        b.setBounds(50,50,50,50);
        setSize(500, 500);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new chat("bb").start();
                    a.setVisible(true);
                    a.start();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        setLayout(null);
        add(b);
        setVisible(true);
    }
    public static void main(String[] args) {
        new sb();
        try {

            //a.start();
            //a.setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

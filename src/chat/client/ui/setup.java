package chat.client.ui;

import javax.swing.*;
import javax.swing.tree.ExpandVetoException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static swingtest.swingConsole.run;

/**
 * Created by 178386610qqcom on 15/4/18.
 */
public class setup extends JFrame {
    private JButton b1= new JButton("注册"),
            b2= new JButton("返回");
    private JLabel j1 =new JLabel("User name:"),
            j2 = new JLabel("Password:"),
            j3 = new JLabel("Nick name:");
    private JTextField t1 = new JTextField();
    private JPasswordField t2 = new JPasswordField();
    private JTextField t3 = new JTextField();

    public setup(){

        setLayout(null);
        int buttonWidth = 75;
        int buttonHeight = 40;
        b2.setBounds(225, 200, buttonWidth, buttonHeight);
        b1.setBounds(125,200,buttonWidth,buttonHeight);
        j1.setBounds(70+25,40,100,100);
        j2.setBounds(75+25,80,100,100);
        j3.setBounds(70+25,120,100,100);
        t1.setBounds(150+25,80,100,20);
        t2.setBounds(150+25,125,100,20);
        t3.setBounds(150 + 25, 160, 100, 20);
        add(t1);
        add(t2);
        add(t3);
        add(j1);
        add(j2);
        add(j3);
        add(b1);
        add(b2);
        setSize(400, 300);
        setVisible(true);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.println("set");
                String name = t1.getText();
                String password = t2.getText();
                String nickname = t3.getText();
                System.out.println(name + password + nickname);
                try {
                    Socket client = new Socket("localhost", 9997);
                    DataInputStream dis = new DataInputStream(client.getInputStream());
                    DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                    dos.writeUTF(name + "|" + password + "&" + nickname);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login();
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new setup();
    }
}

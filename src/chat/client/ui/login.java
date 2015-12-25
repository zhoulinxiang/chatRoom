package chat.client.ui;

import javax.swing.*;
import javax.xml.crypto.Data;
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
public class login extends JFrame{
        private JButton b1= new JButton("登陆"),
                        b2= new JButton("注册");
        private JLabel j1 =new JLabel("User name:"),
                       j2 = new JLabel("Password:");
        private JTextField t1 = new JTextField();
        private JPasswordField t2 = new JPasswordField();



    public login(){
        JFrame i = this;
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.print("log in ");
                String uName = t1.getText();
                String password = t2.getText();
                String msg = uName+"|"+password;
                String msg2="";
                System.out.println(msg);
                try {
                    Socket client = new Socket("localhost",9998);
                    DataOutputStream dos =new DataOutputStream(client.getOutputStream());
                    dos.writeUTF(msg);
                    dos.flush();
                    DataInputStream dis = new DataInputStream(client.getInputStream());
                    msg2=dis.readUTF();
                    System.out.println("msg2:"+msg2);
                    if (!msg2.equals("")){
                        System.out.println("log in");
                        i.setVisible(false);
                        new chat(msg2).start();

                    }else {
                        t1.setText("");
                        t2.setText("");
                        System.out.println("not log in");
                    }

                } catch (IOException e1) {
                    //e1.printStackTrace();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new setup();
                setVisible(false);
            }


        });
        setLayout(null);
        int buttonWidth = 75;
        int buttonHeight = 40;
        b2.setBounds(225, 200, buttonWidth, buttonHeight);
        b1.setBounds(125,200,buttonWidth,buttonHeight);
        j1.setBounds(70+25,40,100,100);
        j2.setBounds(75+25,80,100,100);
        t1.setBounds(150+25,80,100,20);
        t2.setBounds(150+25,125,100,20);
        add(t1);
        add(t2);
        add(j1);
        add(j2);
        add(b1);
        add(b2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("log in");
        this.setSize(400,300);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new login();
    }
}

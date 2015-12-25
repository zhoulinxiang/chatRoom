package swingtest;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static swingtest.swingConsole.*;
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
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //System.out.print("log in ");
                String uName = t1.getText();
                String password = t2.getPassword()+"\n";
                System.out.println(uName+password);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new setup().myshow();
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
        //add(text);
    }
    public static void main(String[] args) {
        run(new login(),400,300);
    }
}

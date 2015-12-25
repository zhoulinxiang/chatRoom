package chat.client.ui;

import chat02.closeUtil;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static swingtest.swingConsole.run;

/**
 * Created by 178386610qqcom on 15/4/19.
 */
public class chat extends JFrame {
    private static Socket client ;
    private static DataInputStream dis ;
    private static DataOutputStream dos ;

    private JTextArea t1 = new JTextArea(),
                      t2 = new JTextArea();
    private JButton b =new JButton("发送");
    private String name="";
    private JPanel j1 = new JPanel(null),
                    j2 = new JPanel(null);
    public chat(String thename){
        name =thename;
        System.out.println("nizaizhelima");
        setLayout(null);
        t1.setBounds(10, 10, 780, 350);
        //t1.paintImmediately(10, 10, 780, 350);
        t2.setBounds(10, 370, 780, 100);
        //t2.paintImmediately(10, 370, 780, 100);
        b.setBounds(350, 480, 100, 50);
        //b.paintImmediately(350, 480, 100, 50);
        this.add(b);
        this.add(t1);
        this.add(t2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(name);
        this.setSize(800, 550);
        this.setVisible(true);
        //this.repaint();
        System.out.println("nizaizhelima2");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = t2.getText();
                System.out.println("msg:" + msg);
                try {
                    dos.writeUTF(msg);
                    dos.flush();
                    t2.setText("");
                } catch (IOException e1) {
                    System.out.println("exception");
                    //e1.printStackTrace();
                }
            }
        });
        //t1.append("caonimei");
        try {
            client = new Socket("localhost",9999);
            dos = new DataOutputStream(client.getOutputStream());
            dis = new DataInputStream(client.getInputStream());
            dos.writeUTF(name);
            dos.flush();
            /*while (true){


                    String msgReceive = "";
                    msgReceive=dis.readUTF();
                    if (!msgReceive.equals(""))
                        t1.append(msgReceive+"\n");


            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //this.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void receive(){
        System.out.println("in receive");
        new Thread(new receiveRunning()).start();
        /*
        //t1.append("lajiwanyi");
        while (true){


                    String msgReceive = "";
                try {
                    msgReceive=dis.readUTF();
                    System.out.println("msgRceive:"+msgReceive);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (!msgReceive.equals("")) {
                this.t1.append(msgReceive + "\n");
                //this.t1.paintImmediately(0, 0, 800, 550);
                //t2.setBounds(10, 370, 780, 100);
                //t2.paintImmediately(0, 0, 800, 500);
                //b.setBounds(350, 480, 100, 50);
                //b.paintImmediately(0, 0, 800, 500);
                //t2.paintImmediately(10, 370, 780, 100);
                //b.paintImmediately(350, 480, 100, 50);
                //this.add(t1);
            }
            //t1.repaint();
            //t2.repaint();
            //b.repaint();


        }*/
    }
    private class receiveRunning implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println("in runing");
                String msgReceive = "";
                try {
                    msgReceive=dis.readUTF();
                    System.out.println("msgRceive:"+msgReceive);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!msgReceive.equals("")) {
                    t1.append(msgReceive + "\n");
                    //this.t1.paintImmediately(0, 0, 800, 550);
                    //t2.setBounds(10, 370, 780, 100);
                    //t2.paintImmediately(0, 0, 800, 500);
                    //b.setBounds(350, 480, 100, 50);
                    //b.paintImmediately(0, 0, 800, 500);
                    //t2.paintImmediately(10, 370, 780, 100);
                    //b.paintImmediately(350, 480, 100, 50);
                    //this.add(t1);
                }
                //t1.repaint();
                //t2.repaint();
                //b.repaint();


            }

        }
    }


    public void start()throws Exception{
        System.out.println("in start");

        //chat a =new chat(name);
        this.receive();
        //run(new chat(name), 800, 550);
    }

    public static void main(String[] args)throws Exception{
        new chat("cc").start();
        //chat a =new chat("aa");
        //a.receive();
        //chat test= new chat("bb");
        //test.myshow("aa");
        //test.test();

    }

}

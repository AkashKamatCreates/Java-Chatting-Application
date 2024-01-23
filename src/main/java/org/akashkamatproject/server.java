package org.akashkamatproject;

import javax.swing.*;
import java.awt.*;

public class server extends JFrame {

    server(){

        setLayout(null);
        setTitle("Java Chatting Application - Akash Kamat");
//        setIconImage(getIconImage(icons/jlogo.webp));

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(34, 40, 49));
        p1.setBounds(0, 0, 600, 60);
        p1.setLayout(null);
        add(p1);


/** dev comment: imageicon is stored in resource package strictly!!! */
        ImageIcon dp1 = new ImageIcon(ClassLoader.getSystemResource("icons/profile.png"));
        Image i1 = dp1.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        ImageIcon dp1f = new ImageIcon(i1);

        JLabel pic = new JLabel(dp1f);
        pic.setBounds(0, 0, 60, 60);
        p1.add(pic);


        setSize(600, 400);
        setLocation(200, 50);
        getContentPane().setBackground(new Color(57, 62, 70));




        setVisible(true);

    }

    public static void main(String[] args) {
        new server();
    }
}

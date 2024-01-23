package org.akashkamatproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class server extends JFrame implements ActionListener {

    static JFrame f = new JFrame();

    server(){

        f.setLayout(null);
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




        JLabel name = new JLabel("Akash Kamat");
//        int panelHeight = p1.getHeight();
//        int labelHeight = name.getPreferredSize().height;
//        int yCoordinate = (panelHeight - labelHeight) / 2;
//        name.setBounds(90, yCoordinate, 200, labelHeight);
        name.setBounds(80, 13, 200, 30);
        name.setForeground(Color.white);
        name.setFont(new Font("Segoe UI", Font.BOLD, 27));
        p1.add(name);


        //jframe for main text area.
        JPanel a1 = new JPanel();
        a1.setBounds(0, 0, 600, 340);
        a1.setBackground(Color.GRAY);
//        a1.setLayout(new FlowLayout()); // Set a layout manager
        add(a1);

//        JTextField text = new JTextField();
//        text.setBounds(300, 300, 310, 40);
//        setBackground(Color.magenta);
//        text.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        add(text);
        JTextField text = new JTextField();
//        text.setBounds(300, 300, 310, 40);
        text.setBounds(5, 500, 100, 30); // Adjusted bounds for one line of text
        text.setBackground(Color.magenta); // Set the background color of the text field
        text.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(text);




/** WARNING: the below code should be untouched since it has main configuration!!! */
        setSize(600, 400);
        setLocation(200, 50);
        getContentPane().setBackground(new Color(57, 62, 70));

        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){}

    public static void main(String[] args) {
        new server();
    }
}

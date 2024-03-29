package org.akashkamatproject;

import javax.swing.*;
import javax.swing.border.* ;
import javax.swing.text.html.HTML;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.net.*;


public class server implements ActionListener {

    static JFrame f = new JFrame();

    JTextField text;
    JPanel a1;
    static Box vertical = Box.createVerticalBox();
    static DataOutputStream dout;



    server(){

        f.setLayout(null);
        f.setTitle("Java Chatting Application - Akash Kamat");
//        setIconImage(getIconImage(icons/jlogo.webp));

        JPanel p1 = new JPanel();
        p1.setBackground(new Color(34, 40, 49));
        p1.setBounds(0, 0, 600, 60);
        p1.setLayout(null);
        f.add(p1);



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




//        JTextField text = new JTextField();
//        text.setBounds(300, 300, 310, 40);
//        setBackground(Color.magenta);
//        text.setFont(new Font("Segoe UI", Font.BOLD, 16));
//        add(text);
        text = new JTextField();
//        text.setBounds(300, 300, 310, 40);
        text.setBounds(0, 740, 500, 60);
        text.setBackground(new Color(45, 50, 80));
        text.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        text.setForeground(Color.WHITE);
//        text.setMargin(new Insets(0, 70, 0, 0));
        text.setBorder(null);
//        text.setMargin(new Insets(0, 10, 0, 0));
        f.add(text);




        JButton send = new JButton("SEND");
        send.setBounds(500, 740, 100, 60);
        send.setBackground(new Color(34, 40, 49));
        send.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        send.setForeground(Color.white);
        send.setBorder(null);
        send.addActionListener(this);
        f.add(send);


        //jframe for main text area.
        a1 = new JPanel();
        a1.setBounds(0, 60, 600, 800);
        a1.setBackground(new Color(57, 62, 70));
//        a1.setLayout(new FlowLayout());
        f.add(a1);


/** WARNING: the below code should be untouched since it has main configuration!!! */
        f.setSize(600, 800);
        f.setLocation(200, 50);
        f.getContentPane().setBackground(new Color(57, 62, 70));

        f.setVisible(true);

    }


    public void actionPerformed(ActionEvent ae) {
        try {
            String out = text.getText();

            JPanel p2 = formatLabel(out);

            a1.setLayout(new BorderLayout());

            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            right.setBackground(new Color(57, 62, 70));
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15));

            a1.add(vertical, BorderLayout.PAGE_START);

            dout.writeUTF(out);

            text.setText("");

            f.repaint();
            f.invalidate();
            f.validate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style =\"width:175px\" >"+out+"</p></html>");
        output.setFont(new Font("Tamoha", Font.BOLD, 20));
        //ORIGINAL COLOR: MAGENTA/DARK PINK
        output.setBackground(new Color(138, 47, 141, 255));
//        output.setBackground(new Color(57, 62, 70));


        output.setForeground(Color.WHITE);

        output.setOpaque(true);
        output.setBorder(new EmptyBorder(10, 10, 10, 25));
//        panel.setBackground(Color.CYAN);
        panel.add(output);


        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        panel.add(time);
        panel.setBackground(new Color(57, 62, 70)); //timing background
        time.setForeground(Color.white);
        time.setBorder(new EmptyBorder(0, 10, 0, 0));


        return panel;
    }

    public static void main(String[] args) {
        new server();

        try{
            ServerSocket skt = new ServerSocket(6001);
            while (true) {
                Socket s = skt.accept();
                DataInputStream din = new DataInputStream(s.getInputStream());
                dout = new DataOutputStream(s.getOutputStream());

                while (true) {
                    String msg = din.readUTF();
                    JPanel panel = formatLabel(msg);

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);
                    left.setBackground(new Color(57, 62, 70));

                    vertical.add(left);
                    f.validate();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

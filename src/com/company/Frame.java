package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {
    String pathname="map.png";
    BufferedImage image;

    Render render =new Render();

    Frame() throws IOException {
        super("Traffic simulation");
        buildGui();
    }

    void buildGui() throws IOException {
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        JPanel northPanel = new JPanel();

        image = ImageIO.read(new File(pathname));
        JLabel picLabel = new JLabel(new ImageIcon(image));

        root.add(picLabel);
        root.repaint();

        JButton start = new JButton("Start");
        start.addActionListener(p -> render.onStart());
        northPanel.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(p->render.onStop());
        stop.setEnabled(false);
        northPanel.add(stop);

        start.addActionListener(p->{start.setEnabled(false);stop.setEnabled(true);});
        stop.addActionListener(p->{stop.setEnabled(false);start.setEnabled(true);});

//        JButton plus = new JButton("Morning");
//        //plus.addActionListener(p->bbPanel.onPlus());
//        northPanel.add(plus);
//
//        JButton minus = new JButton("Afternoon");
//        //minus.addActionListener(p->bbPanel.onMinus());
//        northPanel.add(minus);
//        root.add(northPanel,BorderLayout.NORTH);

        //root.add(bbPanel, BorderLayout.CENTER);
        setContentPane(root);


    }
    public static void main(String[] args) throws IOException {
        Frame frame = new Frame();

        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setVisible(true);

    }
}
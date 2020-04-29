package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Render extends JPanel {
    Algorithm alg = new Algorithm();
    ArrayList<Road> roads = alg.getArrayList(); //wyciagam sobie linkliste z drogami wszystimi
    private BufferedImage getImage(String filename) throws IOException {
        return ImageIO.read(new File(filename));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        BufferedImage img=null;
        try {
            img=getImage("car.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(getWidth() / 2, getHeight() / 2);
        for (Road road:roads) {
            ArrayList<Car> cars = alg.getCars();
            for (Car car : cars) {
                int progress = car.getProgress();
                int roadID = car.getRoadID();
                Road rd = new Road();
                Point2D.Double beg = rd.getBeginning();
                if(roadID==1 || roadID==2 || roadID==3) {
                    double x = beg.x + progress;
                    double y = beg.y;
                }
                else if(roadID==4 || roadID==5 || roadID==6){
                    double x = beg.x;
                    double y = beg.y+progress;
                }

                g2d.drawImage(img, x, y, null);
            }
        }
    }
}

package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Render extends JPanel {
    Algorithm alg = new Algorithm();
    Init init=new Init(400);
    ArrayList<Road> roads=init.roads;
    private BufferedImage image;
    private String filename;

//    private BufferedImage getImage(String filename) throws IOException {
//        return ImageIO.read(new File(filename));
//    }

    public Render (){
        URL resource = getClass().getResource(filename);
        try {
            image = ImageIO.read(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        BufferedImage img=null;
//        try {
//            img=getImage("car.png");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        Graphics2D g2d = (Graphics2D) g;

        for (Road road:roads) {
            int roadID=road.getRoadID();
            int beg = road.getBeginning();
            ArrayList<Car> cars = alg.queues.get(roadID);
            for (Car car : cars) {
                int progress = car.getProgress();
                if(roadID==1 || roadID==2 || roadID==3) {
                    int x = beg.x + progress;
                    int y = beg.y;
                }
                else if(roadID==4 || roadID==5 || roadID==6){
                    int x = beg.x;
                    int y = beg.y+progress;
                }
                g2d.drawImage(image, x, y, null);
            }
        }
    }
}

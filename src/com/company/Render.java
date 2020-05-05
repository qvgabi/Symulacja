package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Render extends JPanel {
    AnimationThread animationEngine = new AnimationThread();
    boolean stop= true;
    Algorithm alg = new Algorithm();
    Init init=new Init();
    ArrayList<Road> roads=init.roads;

    List<Car> toRender =new ArrayList<>(); // tu sobie zapisuje auta ktore się będą miały wyrenderowac


//    private BufferedImage image;
//    private String filename;
//
//    private BufferedImage getImage(String filename) throws IOException {
//        return ImageIO.read(new File(filename));
//    }

//    public Render (){
//        URL resource = getClass().getResource(filename);
//        try {
//            image = ImageIO.read(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    class AnimationThread extends Thread{
        public void run(){
            System.out.printf("sdgsdfgd");
            for(;;){
                if(stop) break;
                try {
                    for (Road road:roads) {
                        int x = 0;
                        int y = 0;
                        int roadID=road.getRoadID();
                        Point2D beg = road.getBeginning();
                        ArrayList<Car> cars = alg.queues.get(roadID); //tu mi nie zgrywa sie z algorithm
                        for (Car car : cars) {
                            int progress = car.getProgress();
                            if(roadID==1 || roadID==2 || roadID==3) {
                                x = (int) (beg.getX() + progress);
                                y = (int) beg.getY();
                            }
                            else if(roadID==4 || roadID==5 || roadID==6){
                                x = (int) beg.getX();
                                y = (int) (beg.getY()+progress);
                            }
                            toRender.add(car); //autka do wyrenderowania, ktore maja tylko wspolrzedne
                        }

                    }
                    repaint();
                    sleep(20);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }
    }

    Render(){
        setBorder(BorderFactory.createStrokeBorder(new BasicStroke(3.0f)));
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Car car : toRender)
            car.paint(g2d);
    }

    void onStart(){
        stop=false;
        if (!animationEngine.isAlive()) {
            System.out.println("Start or resume animation thread");
            animationEngine = new AnimationThread();
            animationEngine.start();
        }
        System.out.println("Start or resume animation thread");
    }

    void onStop(){
        System.out.println("Suspend animation thread");
        stop=true;
    }
}

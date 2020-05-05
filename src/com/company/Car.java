package com.company;;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Car {
    public int roadID;
    public boolean availability = true;
    public int progress;
    public int target;
    private BufferedImage image;
    private String filename;
    int x;
    int y;

    private BufferedImage getImage(String filename) throws IOException {
        return ImageIO.read(new File(filename));
    }

    public int getProgress() {
        return progress;
    }

    public enum Color {
        BLACK, WHITE, GRAY, SILVER, GOLD, RED, GREEN, BLUE
    }

    private Color color;

    public int velocity;
    public int maxVelocity;


    public Car(int velocity, int maxVelocity,int target){
        this.progress = 0;
      //  this.target = new Random().nextInt(1);
        this.target = target%2;
        this.color = Color.values()[new Random().nextInt(Color.values().length)];
        this.velocity = velocity;
        this.maxVelocity = maxVelocity;
    }

    public void putOnRoad(int roadID){
        this.roadID = roadID;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics2D g2d) {
        g2d.drawImage(image, x, y, null);
    }
}

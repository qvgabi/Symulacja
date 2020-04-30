package com.company;;

import java.util.Random;

public class Car {
    public int roadID;
    public boolean availability = true;
    public int progress;
    public int target;

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
}

package com.company;;

public class newCar {
    static int i =-1;



    public int spown() {
    /*    boolean found = false;
        int i = 0;
        while (found == false) {
            if (Init.cars.get(i).availability == true) {
                break;
            }
            i++;
        }
        return i;
    */
        i++;
     return i;




    }


    public int whatroad(int idRoad) {   /*int[] poczatki = {1,4,7,14,16,18};
        int roadID = -1;
        for(int i : poczatki){
            if(Algo.queues.get(i).isEmpty()){
                roadID = i;
                break;
            }
            else {
                if(Init.cars.get(Algo.queues.get(i).getLast()).progress != 0 ){
                    roadID = i;
                    break;
                }
            }

        }

        return roadID;
        */
        int[] poczatki = {0, 2, 3, 6, 13, 15, 17};
        int roadID = poczatki[idRoad];
        if (Algo.queues.get(roadID).isEmpty()) {
            return roadID;
        } else {
            if (Init.cars.get(Algo.queues.get(roadID).getLast()).progress != 0) {
                return roadID;
            }
            return -1;

        }



    }
}
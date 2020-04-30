package com.company;


import java.util.Arrays;
import java.util.LinkedList;


public class Algo {

    static LinkedList<Integer> queue1 = new LinkedList<>();
    static LinkedList<Integer> queue2 = new LinkedList<>();
    static LinkedList<Integer> queue3 = new LinkedList<>();
    static LinkedList<Integer> queue4 = new LinkedList<>();
    static LinkedList<Integer> queue5 = new LinkedList<>();
    static LinkedList<Integer> queue6 = new LinkedList<>();
    static LinkedList<Integer> queue7 = new LinkedList<>();
    static LinkedList<Integer> queue8 = new LinkedList<>();
    static LinkedList<Integer> queue9 = new LinkedList<>();
    static LinkedList<Integer> queue10 = new LinkedList<>();
    static LinkedList<Integer> queue11 = new LinkedList<>();
    static LinkedList<Integer> queue12 = new LinkedList<>();
    static LinkedList<Integer> queue13 = new LinkedList<>();
    static LinkedList<Integer> queue14 = new LinkedList<>();
    static LinkedList<Integer> queue15 = new LinkedList<>();
    static LinkedList<Integer> queue16 = new LinkedList<>();
    static LinkedList<Integer> queue17 = new LinkedList<>();
    static LinkedList<Integer> queue18 = new LinkedList<>();
    static LinkedList<Integer> queue19 = new LinkedList<>();
    static LinkedList<Integer> queue20 = new LinkedList<>();
    static LinkedList<LinkedList<Integer>> queues = new LinkedList<>(Arrays.asList(queue1,queue2,queue3,queue4,queue5,queue6,queue7,queue8,queue9,queue10,queue11,queue12,queue13,queue14,queue15,queue16,queue17,queue18,queue19,queue20));



    int[][] ways = {{1,-2},{-1,-1},{10,-2},{5,-2},{-1,-1},{4,10},{5,-2},{9,8},{4,-2},{1,-2},{11,12},{18,-2},{14,-2},{7,-2},{-1,-1},{14,-2},{7,-2},{16,19},{-1,-1},{18,-2}};
//-----jak jakas droga ma tylko jedno polaczenie to jest ono po lewej stronie a po prawej jest wpisywane -2 , a jak jakas się konczy to ma (-1,-1)

    public void printlist(){
        System.out.println(queues);


    }

    public void update(){
            int j = 0;
            for(LinkedList<Integer> que : queues){
                int k=0;
                for(int i : que ){
                    if(queues.get(j).getLast().equals(queues.get(j).get(k)) && Init.roads.get(j).length - Init.cars.get(i).progress < Init.cars.get(i).velocity){
                        if(next_road_arefree(j,i)){
                            changeRoad(j);
                        }
                    }
                    else{
                        if( distanse_next_car(j,k) > 2 ) {
                             Init.cars.get(i).progress += Init.cars.get(i).velocity;

                        }
                    }
                    k++;
                }
                j++;
            }

    }



 //   public int get_car_id(int roadID){

  //  }


    public int distanse_next_car(int roadID, int que_carID){
        int car1 = queues.get(roadID).get(que_carID);
        if(queues.get(roadID).get(que_carID).equals(queues.get(roadID).getLast())){
            return Init.roads.get(roadID).length - Init.cars.get(car1).progress;
        }
        else{
            int car2 = queues.get(roadID).get(que_carID+1);
            return Init.cars.get(car2).progress - Init.cars.get(car1).progress;
        }
    }

//-------------nastepna droga



    public boolean next_road_arefree( int roadID, int carID) {
        //wartosc targetu samochodu
        int targ = Init.cars.get(carID).target;
        // id_of_next_road_where_our_car_will_drive
        int next_road = ways[roadID][targ];
        if (next_road == -1) return true;

        if (next_road == -2) next_road = ways[roadID][0];
        if (queues.get(next_road).isEmpty()) {
            return true;
        } else {
            // id_of_last_car_on_next_road
            int last_car = queues.get(next_road).getLast();
            //odleglosc od nastepnego samochodu
            int next_dist = 1;
            //---------------------------------------------------------do nadrobienia odleglosc od nastepnego samochodu
            //czy jest wystarczajaco miejsca przed samochodem aby mogl zmienic droge
            return (Init.cars.get(last_car).progress + (Init.roads.get(roadID).length - Init.cars.get(carID).progress) > next_dist);
        }
    }



    public void changeRoad( int roadID) {
        int carID = queues.get(roadID).getLast();
         if(next_road_arefree(roadID,carID)){
            removeCar(roadID);
            int targ = Init.cars.get(carID).target;
            int target;
            if (ways[roadID][targ] == -2) {
                target = ways[roadID][0];
            }
            else{
                target = ways[roadID][targ];
            }

            if (ways[roadID][0] != -1) {
                addCar(carID, target);
            }
       }
    }



    public boolean avable(int carID) {
        if (Init.cars.get(carID).availability) {
            return true;
        }
        else {
            System.out.println("samochód o id : " + carID + " jest już na mapie");
            return false;
        }
    }




    public void removeCar(int roadID){
        int carID = queues.get(roadID).getLast();
        queues.get(roadID).removeLast();
        Init.cars.get(carID).availability = true;
        Init.cars.get(carID).progress = 0;
    }

    public void addCar(int carID,int roadID_n) {
            if(avable(carID)){
                queues.get(roadID_n).addFirst(carID);
                Init.cars.get(carID).roadID = roadID_n;
                Init.cars.get(carID).availability = false;
            }

    }
}

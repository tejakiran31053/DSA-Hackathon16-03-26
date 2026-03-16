package team_project;
import java.util.*;

public class Boarding {

    Scanner sc = new Scanner(System.in);

    String queue[] = new String[50];
    int front = 0;
    int rear = -1;

    void addBoarding(){

        System.out.print("Passenger Name: ");
        String name = sc.next();

        rear++;
        queue[rear] = name;

        System.out.println("Passenger Added To Queue");
    }

    void boardPassenger(){

        if(front > rear){
            System.out.println("Queue Empty");
            return;
        }
        																																																																																																										
        System.out.println("Boarded: "+queue[front]);
        front++;
    }
}
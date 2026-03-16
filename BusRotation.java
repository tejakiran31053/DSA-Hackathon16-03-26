package team_project;
import java.io.*;
import java.util.*;

public class BusRotation {

    String routeFile = "routes.csv";

    int currentIndex = 0;
    String buses[] = new String[50];
    int count = 0;

    void loadBuses() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(routeFile));

        String line;

        count = 0;

        while((line = br.readLine()) != null){

            String arr[] = line.split(",");

            buses[count] = arr[0]; // bus number
            count++;
        }

        br.close();
    }

    void rotateBus() throws Exception {

        loadBuses();

        if(count == 0){
            System.out.println("No buses available");
            return;
        }

        System.out.println("Next Bus: "+buses[currentIndex]);

        currentIndex++;

        if(currentIndex >= count)
            currentIndex = 0;
    }
}
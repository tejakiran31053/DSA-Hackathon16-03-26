package team_project;
import java.io.*;
import java.util.*;

public class Passenger {

    Scanner sc = new Scanner(System.in);
    String passengerFile = "passengers.csv";

    void addPassenger() throws Exception {

        File file = new File(passengerFile);
        if(!file.exists())
            file.createNewFile();

        System.out.print("Passenger ID: ");
        String id = sc.next();

        System.out.print("Passenger Name: ");
        String name = sc.next();

        BufferedWriter bw = new BufferedWriter(new FileWriter(passengerFile,true));

        bw.write(id+","+name);
        bw.newLine();

        bw.close();

        System.out.println("Passenger Added Successfully");
    }

    void showPassengers() throws Exception {

        File file = new File(passengerFile);
        if(!file.exists()){
            System.out.println("No passengers found");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(passengerFile));

        String line;

        while((line=br.readLine())!=null)
            System.out.println(line);

        br.close();
    }

    void deletePassenger() throws Exception {

        showPassengers();

        System.out.print("Enter Passenger ID to delete: ");
        String id = sc.next();

        File input = new File(passengerFile);
        File temp = new File("temp_pass.csv");

        BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

        String line;
        boolean found=false;

        while((line = br.readLine()) != null){

            if(!line.startsWith(id+",")){
                bw.write(line);
                bw.newLine();
            }else{
                found=true;
            }
        }

        br.close();
        bw.close();

        input.delete();
        temp.renameTo(input);

        if(found)
            System.out.println("Passenger Deleted Successfully");
        else
            System.out.println("Passenger Not Found");
    }
}
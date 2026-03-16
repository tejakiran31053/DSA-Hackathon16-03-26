package team_project;

import java.io.*;
import java.util.Scanner;

public class Route {

    Scanner sc = new Scanner(System.in);
    String routeFile = "routes.csv";

    // ADD ROUTE
    void addRoute() throws Exception {

        sc.nextLine(); // clear buffer

        System.out.print("Enter Bus Number: ");
        String bus = sc.nextLine();

        System.out.print("Enter Departure Time (HH:MM): ");
        String time = sc.nextLine();

        System.out.print("Enter number of stops: ");
        int n = sc.nextInt();

        sc.nextLine(); // clear buffer before reading stops

        BufferedWriter bw = new BufferedWriter(new FileWriter(routeFile, true));

        bw.write(bus + "," + time + "," + n);

        for (int i = 0; i < n; i++) {

            System.out.print("Stop " + (i + 1) + ": ");
            String stop = sc.nextLine();

            bw.write("," + stop);
        }

        bw.newLine();
        bw.close();

        System.out.println("Route Added Successfully");
    }

    // SHOW ROUTES
    void showRoutes() throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(routeFile));

        String line;

        while ((line = br.readLine()) != null) {

            String arr[] = line.split(",");

            if (arr.length < 4) continue;

            System.out.println("\nBus No: " + arr[0]);
            System.out.println("Departure Time: " + arr[1]);

            System.out.print("Stops: ");

            for (int i = 3; i < arr.length; i++) {

                System.out.print(arr[i]);

                if (i < arr.length - 1)
                    System.out.print(" -> ");
            }

            System.out.println();
        }

        br.close();
    }

    // DELETE ROUTE
    void deleteRoute() throws Exception {

        System.out.print("Enter Bus Number to delete: ");
        String busNo = sc.next();

        File input = new File(routeFile);
        File temp = new File("temp.csv");

        BufferedReader br = new BufferedReader(new FileReader(input));
        BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {

            String arr[] = line.split(",");

            if (arr[0].equals(busNo)) {
                found = true;
                continue;
            }

            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();

        input.delete();
        temp.renameTo(input);

        if (found)
            System.out.println("Route Deleted Successfully");
        else
            System.out.println("Bus Not Found");
    }
    
    void searchBusByStops() throws Exception {

        System.out.print("Enter Source Stop: ");
        String source = sc.nextLine();

        System.out.print("Enter Destination Stop: ");
        String dest = sc.nextLine();

        BufferedReader br = new BufferedReader(new FileReader(routeFile));

        String line;
        int count = 0;

        // FIRST PASS → COUNT MATCHING BUSES
        while((line = br.readLine()) != null){

            String arr[] = line.split(",");

            int sourceIndex = -1;
            int destIndex = -1;

            for(int i = 3; i < arr.length; i++){

                if(arr[i].equalsIgnoreCase(source))
                    sourceIndex = i;

                if(arr[i].equalsIgnoreCase(dest))
                    destIndex = i;
            }

            if(sourceIndex != -1 && destIndex != -1 && sourceIndex < destIndex)
                count++;
        }

        br.close();

        if(count == 0){
            System.out.println("No buses available for this route.");
            return;
        }

        System.out.println("\nNumber of buses available: " + count);

        // SECOND PASS → DISPLAY BUSES
        br = new BufferedReader(new FileReader(routeFile));

        while((line = br.readLine()) != null){

            String arr[] = line.split(",");

            int sourceIndex = -1;
            int destIndex = -1;

            for(int i = 3; i < arr.length; i++){

                if(arr[i].equalsIgnoreCase(source))
                    sourceIndex = i;

                if(arr[i].equalsIgnoreCase(dest))
                    destIndex = i;
            }

            if(sourceIndex != -1 && destIndex != -1 && sourceIndex < destIndex){

                System.out.println("\nBus No: " + arr[0]);
                System.out.println("Departure Time: " + arr[1]);

                System.out.print("Stops: ");

                for(int i = 3; i < arr.length; i++){

                    System.out.print(arr[i]);

                    if(i < arr.length - 1)
                        System.out.print(" -> ");
                }

                System.out.println();
            }
        }

        br.close();
    }
}
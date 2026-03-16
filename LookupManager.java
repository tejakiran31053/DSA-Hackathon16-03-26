package team_project;
import java.util.HashMap;
import java.util.Scanner;

class LookupManager {       // we used HashMap
    HashMap<String, String> passengerLookup = new HashMap<>();
    HashMap<String, String> trafficAlerts = new HashMap<>();

    void registerPassengerMap(Scanner sc) {
        System.out.print("Enter Passenger ID (e.g., P001): ");
        String id = sc.next();
        System.out.print("Enter Passenger Name: ");
        String name = sc.next();
        passengerLookup.put(id, name);
        System.out.println("Passenger registered in fast lookup.");
    }

    void lookupPassenger(Scanner sc) {
        System.out.print("Enter Passenger ID to lookup: ");
        String id = sc.next();
        if (passengerLookup.containsKey(id)) {
            System.out.println("Passenger Found: " + passengerLookup.get(id));
        } else {
            System.out.println("Passenger not found.");
        }
    }

    void addTrafficAlert(Scanner sc) {
        System.out.print("Enter Route Code (e.g., R1): ");
        String code = sc.next();
        System.out.print("Enter Alert Message: ");
        sc.nextLine(); // consume newline
        String alert = sc.nextLine();
        trafficAlerts.put(code, alert);
        System.out.println("Traffic alert added for route " + code);
    }

    void checkTrafficAlert(Scanner sc) {
        System.out.print("Enter Route Code to check alerts: ");
        String code = sc.next();
        System.out.println("Alert for " + code + ": " + trafficAlerts.getOrDefault(code, "No alerts."));
    }
}

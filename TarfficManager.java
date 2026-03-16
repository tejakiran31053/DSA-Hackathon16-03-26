package team_project;
import java.util.Scanner;

class TrafficManager {

    String[] alerts = new String[10];
    int count = 0;

    void addAlert(Scanner sc) {

        System.out.print("Enter traffic alert: ");
        alerts[count++] = sc.next();

        System.out.println("Alert stored");
    }

    void showAlerts() {

        if (count == 0) {
            System.out.println("No alerts");
            return;
        }

        for (int i = 0; i < count; i++)
            System.out.println(alerts[i]);
    }
}
package team_project;
import java.util.Scanner;

class Node {

    int priority;
    String incident;
    Node next;

    Node(int p,String i){
        priority = p;
        incident = i;
        next = null;
    }
}

public class IncidentManage{

    Scanner sc = new Scanner(System.in);
    Node head = null;

    // REPORT INCIDENT
    void reportIncident(){

        sc.nextLine();

        System.out.print("Enter Incident: ");
        String inc = sc.nextLine();

        System.out.print("Enter Priority (1-High 2-Medium 3-Low): ");
        int p = sc.nextInt();

        Node newNode = new Node(p,inc);

        if(head == null)
            head = newNode;
        else{

            Node temp = head;

            while(temp.next != null)
                temp = temp.next;

            temp.next = newNode;
        }

        System.out.println("Incident Reported Successfully");
    }

    // SHOW INCIDENTS
    void showIncidents(){

        if(head == null){
            System.out.println("No incidents reported");
            return;
        }

        Node temp = head;

        System.out.println("\nPending Incidents:");

        while(temp != null){

            System.out.println(
                    "Priority: " + temp.priority +
                    " -> " + temp.incident
            );

            temp = temp.next;
        }
    }

    // HANDLE INCIDENT
    void handleIncident(){

        if(head == null){
            System.out.println("No incidents to handle");
            return;
        }

        Node temp = head, prev = null;
        Node high = head, highPrev = null;

        while(temp != null){

            if(temp.priority < high.priority){
                high = temp;
                highPrev = prev;
            }

            prev = temp;
            temp = temp.next;
        }

        System.out.println("\nHandling Incident:");
        System.out.println("Priority: " + high.priority);
        System.out.println("Incident: " + high.incident);

        if(highPrev == null)
            head = head.next;
        else
            highPrev.next = high.next;
    }
}
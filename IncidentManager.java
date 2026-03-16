package team_project;
import java.util.PriorityQueue;
import java.util.Scanner;

class Incident implements Comparable<Incident> {
    String description;
    int severity;

    Incident(String description, int severity) {
        this.description = description;
        this.severity = severity;
    }

    @Override
    public int compareTo(Incident other) {
        // Max-Heap: higher severity comes first
        return Integer.compare(other.severity, this.severity);
    }
}

class IncidentManager {     // we used Priority Queue (Max-Heap)
    PriorityQueue<Incident> pq = new PriorityQueue<>();

    void reportIncident(Scanner sc) {
        System.out.print("Enter incident description: ");
        sc.nextLine(); // consume newline
        String desc = sc.nextLine();
        System.out.print("Enter severity (1-10): ");
        int severity = sc.nextInt();
        pq.add(new Incident(desc, severity));
        System.out.println("Incident reported with severity " + severity);
    }

    void handleIncident() {
        if (!pq.isEmpty()) {
            Incident inc = pq.poll();
            System.out.println("Handling Incident: " + inc.description + " (Severity: " + inc.severity + ")");
        } else {
            System.out.println("No incidents to handle.");
        }
    }
}

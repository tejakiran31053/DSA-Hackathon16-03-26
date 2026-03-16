package team_project;
import java.util.Scanner;

public class Main_method {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        Route route = new Route();
        Passenger passenger = new Passenger();
        Boarding board = new Boarding();
        BusRotation bus = new BusRotation();
        PassManager pass = new PassManager();
        IncidentManage incident = new IncidentManage();

        int choice;

        while(true){

            System.out.println("\n===== CITY MOVE =====");

            System.out.println("1. Add Route");
            System.out.println("2. Show Routes");
            System.out.println("3. Delete Route");

            System.out.println("4. Add Passenger");
            System.out.println("5. Show Passengers");

            System.out.println("6. Add to Boarding Queue");
            System.out.println("7. Board Passenger");

            System.out.println("8. Rotate Bus (from CSV)");

            System.out.println("9. Add Pass");
            System.out.println("10. Validate Pass");

            System.out.println("11. Report Incident");
            System.out.println("12. Show Incidents");
            System.out.println("13. Handle Incident");
            System.out.println("14. Search Bus Between Stops");

            System.out.println("0. Exit");

            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch(choice){

                case 1:
                    route.addRoute();
                    break;

                case 2:
                    route.showRoutes();
                    break;

                case 3:
                    route.deleteRoute();
                    break;

                case 4:
                    passenger.addPassenger();
                    break;

                case 5:
                    passenger.showPassengers();
                    break;

                case 6:
                    board.addBoarding();
                    break;

                case 7:
                    board.boardPassenger();
                    break;

                case 8:
                    bus.rotateBus();
                    break;

                case 9:
                    pass.addPass();
                    break;

                case 10:
                    pass.validatePass();
                    break;

                case 11:
                    incident.reportIncident();
                    break;

                case 12:
                    incident.showIncidents();
                    break;

                case 13:
                    incident.handleIncident();
                    break;
                    
                case 14:
                    route.searchBusByStops();
                    break;

                case 0:
                    System.out.println("Program Ended");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
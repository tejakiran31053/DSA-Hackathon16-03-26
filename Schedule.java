package team_project;
import java.util.Scanner;

class ScheduleManager {  //We used Custom stack

    String[] stack = new String[10];
    int top = -1;

    void updateSchedule(Scanner sc) {

        if (top == stack.length - 1) {
            System.out.println("Stack overflow");
            return;
        }

        System.out.print("Enter update: ");
        stack[++top] = sc.next();

        System.out.println("Schedule updated");
    }

    void undoSchedule() {

        if (top == -1)
            System.out.println("No updates");
        else
            System.out.println("Undo: " + stack[top--]);
    }
}
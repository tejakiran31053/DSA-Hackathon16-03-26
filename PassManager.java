package team_project;
import java.util.*;

class Pass {

    String id;
    String name;

    Pass(String i,String n){
        id = i;
        name = n;
    }
}

public class PassManager {

    Scanner sc = new Scanner(System.in);

    Pass passes[] = new Pass[50];
    int count = 0;

    void addPass(){

        System.out.print("Pass ID: ");
        String id = sc.next();

        System.out.print("Passenger Name: ");
        String name = sc.next();

        passes[count] = new Pass(id,name);
        count++;

        System.out.println("Pass Added");
    }

    void validatePass(){

        System.out.print("Enter Pass ID: ");
        String id = sc.next();

        for(int i=0;i<count;i++){

            if(passes[i].id.equals(id)){
                System.out.println("Valid Pass for "+passes[i].name);
                return;
            }
        }

        System.out.println("Invalid Pass");
    }
}
package com.danilkobeliatskyi;

import java.util.Scanner;

public class Program {
    ContactActor actor = new ContactActor("D:\\Notes\\notes.txt");
    Scanner scanner = new Scanner(System.in);

    public void run(){

        System.out.println("Click 1 to see all contacts");
        System.out.println("Click 2 to add a new contact");
        System.out.println("Click 3 to delete contact");
        System.out.println("Click 4 to delete all contacts");
        System.out.println("Click 5 to change name of contact");
        System.out.println("Click 6 to change phone of contact");
        System.out.println("Click 7 to change email of contact");
        System.out.println("Click 8 to find a contact");
        System.out.println("Click 0 to exit the program");

        String action = scanner.nextLine();

        while (!action.equals("0")){

            if(action.equals("1")) {
                actor.showAllContact();
                break;
            }

            if (action.equals("2")) {
                actor.addContact();
                break;
            }

            if (action.equals("3")) {
                actor.deleteContact();
                break;
            }

            if (action.equals("4")) {
                actor.deleteAllContact();
                break;
            }

            if (action.equals("5")) {
                actor.replaceContactName();
                break;
            }

            if (action.equals("6")) {
                actor.replaceContactPhone();
                break;
            }

            if (action.equals("7")) {
                actor.replaceContactEmail();
                break;
            }

            if (action.equals("8")) {
                actor.findContact();
                break;
            }
        }
    }
}

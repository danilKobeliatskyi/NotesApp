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
        System.out.println("Click 9 to exit the program");

        while (0 == 0){

        String action = scanner.nextLine();

            if(action.equals("1")) {
                actor.showAllContact();
            }

            if (action.equals("2")) {
                System.out.println("Enter name");
                String name = scanner.nextLine();
                System.out.println("Enter phone");
                String phone = scanner.nextLine();
                System.out.println("Enter email");
                String email = scanner.nextLine();
                actor.addContact(name, phone, email);
            }

            if (action.equals("3")) {
                System.out.println("Enter name of contact, which you wood to delete");
                String name = scanner.nextLine();
                actor.deleteContact(name);
            }

            if (action.equals("4")) {
                actor.deleteAllContact();
            }

            if (action.equals("5")) {
                System.out.println("Enter old name");
                String name = scanner.nextLine();
                System.out.println("Enter new name");
                String newName = scanner.nextLine();
                actor.replaceContactName(name, newName);
            }

            if (action.equals("6")) {
                System.out.println("Enter old phone");
                String phone = scanner.nextLine();
                System.out.println("Enter new phone");
                String newPhone = scanner.nextLine();
                actor.replaceContactPhone(phone, newPhone);
            }

            if (action.equals("7")) {
                System.out.println("Enter old email");
                String email = scanner.nextLine();
                System.out.println("Enter new email");
                String newEmail = scanner.nextLine();
                actor.replaceContactEmail(email, newEmail);
            }

            if (action.equals("8")) {
                System.out.println("Enter name of contact, which you wood like to find");
                String name = scanner.nextLine();
                actor.findContact(name);
            }

            if (action.equals("0")){
                break;
            }
        }
    }
}

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

        while (true){

        String action = scanner.nextLine();
            switch (action) {
                case "1" : actor.showAllContact();
                break;

                case "2" : addContact();
                break;

                case "3" : deleteContact();
                    break;

                case "4" : actor.deleteAllContact();
                    break;

                case "5" : replaceName();
                    break;

                case "6" : replacePhone();
                    break;

                case "7" : replaceEmail();
                    break;

                case "8" : findContact();
                    break;

                case "0" : System.exit(0);
                    break;
            }
        }
    }

    private void addContact(){
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter phone");
        String phone = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        actor.addContact(name, phone, email);
    }

    private void deleteContact(){
        System.out.println("Enter name of contact, which you wood to delete");
        String name = scanner.nextLine();
        actor.deleteContact(name);
    }

    private void replaceName(){
        System.out.println("Enter old name");
        String name = scanner.nextLine();
        System.out.println("Enter new name");
        String newName = scanner.nextLine();
        actor.replaceContactName(name, newName);
    }

    private void replacePhone(){
        System.out.println("Enter old phone");
        String phone = scanner.nextLine();
        System.out.println("Enter new phone");
        String newPhone = scanner.nextLine();
        actor.replaceContactPhone(phone, newPhone);
    }

    private void replaceEmail(){
        System.out.println("Enter old email");
        String email = scanner.nextLine();
        System.out.println("Enter new email");
        String newEmail = scanner.nextLine();
        actor.replaceContactEmail(email, newEmail);
    }

    private void findContact(){
        System.out.println("Enter name of contact, which you wood like to find");
        String name = scanner.nextLine();
        actor.findContact(name);
    }
}

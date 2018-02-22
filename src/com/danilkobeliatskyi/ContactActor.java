package com.danilkobeliatskyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactActor {

    private Scanner scanner = new Scanner(System.in);
    private String filename;
    private List<Contact> data;
    FileManager fileManager;

    public ContactActor(String filename) {
        this.filename = filename;
        fileManager = new FileManager(filename);
        data = fileManager.getAllData();
    }

    public void showAllContact(){
        for (Contact contact : data){
            printContact(contact);
        }
    }

    public void addContact(){
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter phone");
        String phone = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phone, email);
        data.add(contact);
        fileManager.addContact(contact);
    }

    public void replaceContactName(){
        System.out.println("Enter old name");
        String name = scanner.nextLine();
        String newName;

        for (Contact contact : data)
            if (contact.getName().contains(name)) {
            System.out.println("Enter new name");
            newName = scanner.nextLine();
            Contact newContact = new Contact(contact.getName().replace(contact.getName(), newName), contact.getPhone(), contact.getEmail());
            data.remove(contact);
            data.add(newContact);

            fileManager.updateContacts(data);
            }
    }

    public void replaceContactPhone(){
        System.out.println("Enter old phone");
        String phone = scanner.nextLine();
        String newPhone;

        for (Contact contact : data)
            if (contact.getPhone().contains(phone)) {
            System.out.println("Enter new phone");
            newPhone = scanner.nextLine();
            Contact newContact = new Contact(contact.getName(), contact.getPhone().replace(contact.getPhone(), newPhone), contact.getEmail());
            data.remove(contact);
            data.add(newContact);

            fileManager.updateContacts(data);
            }
    }

    public void replaceContactEmail(){
        System.out.println("Enter old email");
        String email = scanner.nextLine();
        String newEmail;

        for (Contact contact : data)
            if (contact.getEmail().contains(email)) {
            System.out.println("Enter new email");
            newEmail = scanner.nextLine();
            Contact newContact = new Contact(contact.getName(), contact.getPhone(), contact.getEmail().replace(contact.getName(), newEmail));
            data.remove(contact);
            data.add(newContact);

            fileManager.updateContacts(data);
            }
    }

    public void deleteContact(){
        System.out.println("Enter name of contact, which you wood to delete");
        String name = scanner.nextLine();

        List<Contact> newContacts = new ArrayList<>();

        for (Contact contact : data)
            if (!contact.getName().equals(name))
                newContacts.add(contact);
        data.clear();
        data.addAll(newContacts);

        fileManager.updateContacts(data);
    }

    public void findContact(){
        System.out.println("Enter name of contact, which you wood like to find");
        String name = scanner.nextLine();
        for (Contact contact : data)
            if (contact.getName().equals(name))
                printContact(contact);
    }

    public void deleteAllContact(){
        data.clear();
        fileManager.clearAll();
    }

    private void printContact(Contact contact){
        System.out.println("Name: " + contact.getName() + " phone: " + contact.getPhone() + " email: " + contact.getEmail());
    }
}

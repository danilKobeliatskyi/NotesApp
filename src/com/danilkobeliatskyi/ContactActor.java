package com.danilkobeliatskyi;

import java.util.ArrayList;
import java.util.List;

public class ContactActor {

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

    public void addContact(String name, String phone, String email){
        Contact contact = new Contact(name, phone, email);
        data.add(contact);
        fileManager.addContact(contact);
    }

    public void deleteContact(String name){

        List<Contact> newContacts = new ArrayList<>();

        for (Contact contact : data)
            if (!contact.getName().equals(name))
                newContacts.add(contact);
        data.clear();
        data.addAll(newContacts);

        fileManager.updateContacts(data);
    }

    public void findContact(String name){
        for (Contact contact : data)
            if (contact.getName().equals(name))
                printContact(contact);
    }

    public void deleteAllContact(){
        data.clear();
        fileManager.clearAll();
    }

    private void printContact(Contact contact){
        System.out.println("Name: " + contact.getName() + " phone:" + contact.getPhone() + " email:" + contact.getEmail());
    }
}

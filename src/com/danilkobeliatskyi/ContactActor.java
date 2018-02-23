package com.danilkobeliatskyi;

import java.util.ArrayList;
import java.util.List;

public class ContactActor {

    private List<Contact> data;
    FileManager fileManager;

    public ContactActor(String filename) {
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

    public void replaceContactName(String name, String newName){
        for (Contact contact : data) {
            if (contact.getName().contains(name))
                contact.setName(newName);
            fileManager.updateContacts(data);
        }
    }

    public void replaceContactPhone(String phone, String newPhone){
        for (Contact contact : data){
            if (contact.getPhone().contains(phone))
                contact.setPhone(newPhone);
            fileManager.updateContacts(data);
        }
    }

    public void replaceContactEmail(String email, String newEmail){
        for (Contact contact : data){
            if (contact.getEmail().contains(email))
                contact.setEmail(newEmail);
            fileManager.updateContacts(data);
        }
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
        System.out.println("Name: " + contact.getName() + " phone: " + contact.getPhone() + " email: " + contact.getEmail());
    }
}

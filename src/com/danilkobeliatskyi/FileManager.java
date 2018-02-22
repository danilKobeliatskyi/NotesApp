package com.danilkobeliatskyi;

import java.io.BufferedReader;
import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    public List<Contact> getAllData(){
        List<Contact> contacts = new ArrayList<>();
        File file = new File(filename);
        String line;
        String[] subStr;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                subStr = line.split(",");
                Contact contact = new Contact(subStr[0], subStr[1], subStr[2]);
                contacts.add(contact);
            }
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return contacts;
    }

    public void addContact(Contact contact){
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(contactToString(contact));
            writer.close();
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void updateContacts(List<Contact> contacts){
        clearAll();
        try {
            FileWriter writer = new FileWriter(filename, true);
            for (Contact contact : contacts){
                writer.write(contactToString(contact));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void clearAll(){
        try {
            PrintWriter writer = new PrintWriter(filename);
            writer.print("");
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String contactToString(Contact contact){
        return contact.getName() + ", " + contact.getPhone() + ", " +  contact.getEmail() + "\n";
    }
}

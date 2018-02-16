package com.danilkobeliatskyi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main{

    public static void main(String[] args) {

        ContactActor actor = new ContactActor("D:\\Заметки\\notes.txt");
        //actor.showAllContact();
        actor.findContact("Jon");
        //actor.addContact("Billy", "348459261575", "Billy348@example.com");
        actor.deleteContact("Jon");
        actor.showAllContact();
    }
}

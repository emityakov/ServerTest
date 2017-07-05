package com.example.student1.servertest;

import android.os.*;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by student1 on 05.07.17.
 */
public class Messages{
    ArrayList<Message> persons;

    @Override
    public String toString() {
        String result = "";
        Iterator i = persons.iterator();
        while (i.hasNext()) {
            Message person = (Message)i.next();
            result += person.toString() + "\n\n";
        }
        return result;
    }

}

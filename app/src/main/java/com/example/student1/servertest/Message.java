package com.example.student1.servertest;

/**
 * Created by student1 on 05.07.17.
 */
public class Message {
    Integer id;
    Integer id_user;
    String name;
    Integer date;
    String text;
//	ArrayList<Integer> data;

    @Override
    public String toString() {
        return "#" + id + "\nid_user: " + id_user + "\nName: " + name + "\nDate: " + date + "\nText: " + text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (id != message.id) return false;
        if (id_user != message.id_user) return false;
        if (date != message.date) return false;
        if (!name.equals(message.name)) return false;
        return text.equals(message.text);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + id_user;
        result = 31 * result + name.hashCode();
        result = 31 * result + date;
        result = 31 * result + text.hashCode();
        return result;
    }

    public Message(int date, int id, int id_user, String name, String text) {

        this.date = date;
        this.id = id;
        this.id_user = id_user;
        this.name = name;
        this.text = text;
    }
}

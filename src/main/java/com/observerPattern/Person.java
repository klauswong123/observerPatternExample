package com.observerPattern;

public class Person implements Observer{
    private final String Name;

    Person(String Name){
        this.Name = Name;
    }

    public String getName(){
        return this.Name;
    }

    public void update(Mail mail){
        System.out.print(mail.getMailContent());
    }
}

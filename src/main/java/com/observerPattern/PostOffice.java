package com.observerPattern;

import java.util.ArrayList;

public class PostOffice implements Subject {
    private final ArrayList<Observer> subscriptionList = new ArrayList<>();

    public void getNewMail(Mail mail){
        notification(mail);
    }

    public void subscribeBy(Observer observer){
        subscriptionList.add(observer);
    }

    public void unsubscribeBy(Observer observer){
        subscriptionList.remove(observer);
    }

    public void notification(Mail mail){
        subscriptionList.forEach(subscribePerson->subscribePerson.update(mail));
    }
}

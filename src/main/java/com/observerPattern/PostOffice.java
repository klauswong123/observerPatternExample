package com.observerPattern;

import java.util.ArrayList;

public class PostOffice implements Broadcast{
    private final ArrayList<Person> subscriptionList = new ArrayList<>();

    public void getNewMail(Mail mail){
        notification(mail);
    }

    public void subscriptBy(Person person){
        subscriptionList.add(person);
    }

    public void unsubscriptBy(Person person){
        subscriptionList.remove(person);
    }

    public void notification(Mail mail){
        subscriptionList.stream().filter(
                subscriptPerson->subscriptPerson.getName().equals(mail.getReceiverName())
                )
                .findFirst()
                .ifPresent(subscriptionPerson->subscriptionPerson.update(mail));
    }
}

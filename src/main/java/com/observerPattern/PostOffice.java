package com.observerPattern;

import java.util.ArrayList;

public class PostOffice implements Subject {
    private final ArrayList<Person> subscriptionList = new ArrayList<>();

    public void getNewMail(Mail mail){
        notification(mail);
    }

    public void subscribeBy(Person person){
        subscriptionList.add(person);
    }

    public void unsubscribeBy(Person person){
        subscriptionList.remove(person);
    }

    public void notification(Mail mail){
        subscriptionList.stream().filter(
                subscribePerson->subscribePerson.getName().equals(mail.getReceiverName())
                )
                .findFirst()
                .ifPresent(subscribePerson->subscribePerson.update(mail));
    }
}

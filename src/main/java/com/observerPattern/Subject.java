package com.observerPattern;

public interface Subject {
    void subscribeBy(Person person);
    void unsubscribeBy(Person person);
    void notification(Mail mail);
}

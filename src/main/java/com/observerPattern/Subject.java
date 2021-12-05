package com.observerPattern;

public interface Subject {
    void subscribeBy(Observer observer);
    void unsubscribeBy(Observer observer);
    void notification(Mail mail);
}

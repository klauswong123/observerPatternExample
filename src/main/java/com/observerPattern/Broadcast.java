package com.observerPattern;

public interface Broadcast {
    void subscriptBy(Person person);
    void unsubscriptBy(Person person);
    void notification(Mail mail);

}

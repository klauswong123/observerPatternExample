package com.observerPattern;

public class Main {
    public static void main(String[] args) {
        //given
        Person Jason = new Person("Jason");
        Person Klaus = new Person("Klaus");
        PostOffice hkPostOffice= new PostOffice();
        hkPostOffice.subscriptBy(Jason);
        hkPostOffice.subscriptBy(Klaus);
        String mailSubject = "Greeting";
        String mailBody = "Hi Jason, i heard that you are a very good singer.";
        Mail newMailByKlaus = new Mail(Klaus.getName(),Jason.getName(),mailSubject,mailBody);
        hkPostOffice.getNewMail(newMailByKlaus);
    }
}

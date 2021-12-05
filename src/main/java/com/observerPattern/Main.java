package com.observerPattern;

public class Main {
    public static void main(String[] args) {
        //given
        Person Jason = new Person("Jason");
        Person Klaus = new Person("Klaus");
        PostOffice hkPostOffice= new PostOffice();
        hkPostOffice.subscribeBy(Jason);
        hkPostOffice.subscribeBy(Klaus);
        //when
        String mailSubject = "Greeting";
        String mailBody = "Hi Jason, i heard that you are a very good singer.\n\n";
        Mail newMailByKlaus = new Mail(Klaus.getName(),Jason.getName(),mailSubject,mailBody);
        hkPostOffice.getNewMail(newMailByKlaus);
        //when
        String mailSubjectByJason = "Greeting";
        String mailBodyByJason = "Hi Klaus, of course, I am the best singer ever.\n\n";
        Mail newMailByJason = new Mail(Jason.getName(),Klaus.getName(),mailSubjectByJason,mailBodyByJason);
        hkPostOffice.getNewMail(newMailByJason);
        //when
        String mailSubjectbyKlaus = "Greeting";
        String mailBodybyKlaus = "Hi Jason, i heard that you are a very good singer.\n\n";
        hkPostOffice.unsubscribeBy(Jason);
        Mail newMailSendToUnsubsribe = new Mail(Klaus.getName(),Jason.getName(),mailSubjectbyKlaus,mailBodybyKlaus);
        hkPostOffice.getNewMail(newMailSendToUnsubsribe);
    }
}

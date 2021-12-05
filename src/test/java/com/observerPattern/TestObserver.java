package com.observerPattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestObserver {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }
    private String systemOut() {
        return outContent.toString();
    }
    @Test
    public void should_return_email_body_when_send_new_mail_given_person_postOffice_and_mail(){
        //given
        Person Jason = new Person("Jason");
        Person Klaus = new Person("Klaus");
        PostOffice hkPostOffice= new PostOffice();
        hkPostOffice.subscribeBy(Jason);
        hkPostOffice.subscribeBy(Klaus);
        String mailSubject = "Greeting";
        String mailBody = "Hi Jason, i heard that you are a very good singer.";
        //when
        Mail newMailByKlaus = new Mail(Klaus.getName(),Jason.getName(),mailSubject,mailBody);
        hkPostOffice.getNewMail(newMailByKlaus);
        //should
        assertEquals("Sender: Klaus\n" +
                "Receiver: Jason\n" +
                "Subject: Greeting\n" +
                "Hi Jason, i heard that you are a very good singer.", systemOut());
    }

    @Test
    public void should_return_email_body_when_send_new_mail_given_person_postOffice_and_mail_1(){
        //given
        Person Jason = new Person("Jason");
        Person Klaus = new Person("Klaus");
        PostOffice hkPostOffice= new PostOffice();
        hkPostOffice.subscribeBy(Jason);
        hkPostOffice.subscribeBy(Klaus);
        String mailSubject = "Greeting";
        String mailBody = "Hi Klaus, of course, I am the best singer ever";
        //when
        Mail newMailByJason = new Mail(Jason.getName(),Klaus.getName(),mailSubject,mailBody);
        hkPostOffice.getNewMail(newMailByJason);
        //should
        assertEquals("Sender: Jason\n" +
                "Receiver: Klaus\n" +
                "Subject: Greeting\n" +
                "Hi Klaus, of course, I am the best singer ever",systemOut());
    }

    @Test
    public void should_return_null_when_send_new_mail_given_unsubscribePerson_postOffice_and_mail(){
        //given
        Person Jason = new Person("Jason");
        Person Klaus = new Person("Klaus");
        PostOffice hkPostOffice= new PostOffice();
        hkPostOffice.subscribeBy(Jason);
        hkPostOffice.subscribeBy(Klaus);
        String mailSubject = "Greeting";
        String mailBody = "Hi Jason, really?";
        hkPostOffice.unsubscribeBy(Jason);
        //when
        Mail newMailToJason = new Mail(Klaus.getName(),Jason.getName(),mailSubject,mailBody);
        hkPostOffice.getNewMail(newMailToJason);
        //should
        assertEquals("",systemOut());
    }
}

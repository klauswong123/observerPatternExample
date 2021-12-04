package com.observerPattern;

public class Mail {
    private final String senderName;
    private final String receiverName;
    private final String mailSubject;
    private final String mailBody;
    Mail(String senderName,String receiverName,String mailSubject,String mailBody){
        this.senderName=senderName;
        this.receiverName=receiverName;
        this.mailSubject=mailSubject;
        this.mailBody=mailBody;
    }

    public String getReceiverName(){
        return this.receiverName;
    }
    public String getMailContent(){
        return String.format("Sender: %s\nReceiver: %s\nSubject: %s\n%s",this.senderName,this.receiverName,this.mailSubject,this.mailBody);
    }
}

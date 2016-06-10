package edu.galileo.android.androidchat.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by carlos.gomez on 10/06/2016.
 */
@JsonIgnoreProperties({"sentByMe"})
public class ChatMessage {
    private String msg;
    private String sender;
    private boolean sentByMe; //propiedad a ignorar, firebase no va a guardar. Se usa el annotation JsonIgnoreProperties

    public ChatMessage() {} //constructor vacío para que firebase no de un error

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public boolean isSentByMe() {
        return sentByMe;
    }

    public void setSentByMe(boolean sentByMe) {
        this.sentByMe = sentByMe;
    }
}

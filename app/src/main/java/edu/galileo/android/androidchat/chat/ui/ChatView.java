package edu.galileo.android.androidchat.chat.ui;

import edu.galileo.android.androidchat.entities.ChatMessage;

/**
 * Created by carlos.gomez on 10/06/2016.
 */
public interface ChatView {
    void onMessageReceived(ChatMessage msg);
}

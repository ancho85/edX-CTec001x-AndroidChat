package edu.galileo.android.androidchat.contactlist;

/**
 * Created by carlos.gomez on 09/06/2016.
 */
public interface ContactLIstSessionInteractor {
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}

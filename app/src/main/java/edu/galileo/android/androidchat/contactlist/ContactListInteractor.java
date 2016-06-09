package edu.galileo.android.androidchat.contactlist;

/**
 * Created by carlos.gomez on 09/06/2016.
 */
public interface ContactListInteractor {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContact(String email);
}

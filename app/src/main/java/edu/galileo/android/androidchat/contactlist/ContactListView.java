package edu.galileo.android.androidchat.contactlist;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by carlos.gomez on 09/06/2016.
 */
public interface ContactListView {
    void onContactAdded(User user);
    void onContactChanged(User user);
    void onContactRemoved(User user);
}

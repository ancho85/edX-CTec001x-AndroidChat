package edu.galileo.android.androidchat.contactlist;

/**
 * Created by carlos.gomez on 09/06/2016.
 */
public interface ContactListPresenter {
    //trabajo con firebase y hay conexión en tiempo real
    void onPause();
    void onResume();
    //configuraciones
    void onCreate();
    void onDestroy();

    void onSignOff();
    String getCurrentUserEmail();
    void removeContact(String email);
    //eventos
    void onEventMainThread(ContactListEvent event);
}

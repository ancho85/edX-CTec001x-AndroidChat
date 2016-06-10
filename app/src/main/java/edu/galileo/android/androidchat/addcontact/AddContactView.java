package edu.galileo.android.androidchat.addcontact;

/**
 * Created by carlos.gomez on 10/06/2016.
 */
public interface AddContactView {
    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNotAdded();

}

package edu.galileo.android.androidchat.login;

/**
 * Created by carlos.gomez on 07/06/2016.
 */
public interface LoginInteractor {
    //el interactor estará trabajando los casos de uso
    void checkSession();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}

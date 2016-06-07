package edu.galileo.android.androidchat.login;

/**
 * Created by carlos.gomez on 07/06/2016.
 */
public interface LoginPresenter {
    //este presentador estará vinculado a la vista, entonces la vista será una actividad y es posible
    //que tenga un memory leak, entonces al destruir la vista destruyo también la variable del presentador
    void onDestroy();

    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
}

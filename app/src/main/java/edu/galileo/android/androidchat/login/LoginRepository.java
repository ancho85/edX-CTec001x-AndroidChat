package edu.galileo.android.androidchat.login;

/**
 * Created by carlos.gomez on 07/06/2016.
 */
public interface LoginRepository {
    // interacción con el backend (en este caso, Firebase). Esta es la única clase que se entera
    // que se está usando Firebase
    void signUp(String email, String password);
    void signIn(String email, String password);
    void checkSession();
}

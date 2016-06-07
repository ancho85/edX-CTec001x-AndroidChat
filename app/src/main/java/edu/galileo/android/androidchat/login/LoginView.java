package edu.galileo.android.androidchat.login;

/**
 * Created by carlos.gomez on 07/06/2016.
 */
public interface LoginView {
    // evitar multiples clicks en los botones
    void enableInputs();
    void disableInputs();

    void showProgress();
    void hideProgress();

    void handleSignUp();
    void handleSingIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void newUserError(String error);
}

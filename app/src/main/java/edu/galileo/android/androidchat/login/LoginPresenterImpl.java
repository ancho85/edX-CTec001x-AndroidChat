package edu.galileo.android.androidchat.login;

import edu.galileo.android.androidchat.login.events.LoginEvent;

/**
 * Created by carlos.gomez on 07/06/2016.
 */
public class LoginPresenterImpl implements LoginPresenter {
    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void onDestroy() {
        loginView = null; //para evitar el memory leak
    }

    @Override
    public void checkForAuthenticatedUser() {
        if (loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.checkSession();
    }

    @Override
    public void validateLogin(String email, String password) {
        if (loginView != null){
        loginView.disableInputs();
        loginView.showProgress();
        }
        loginInteractor.doSignIn(email, password);
    }

    @Override
    public void registerNewUser(String email, String password) {
        if (loginView != null){
            loginView.disableInputs();
            loginView.showProgress();
        }
        loginInteractor.doSignUp(email, password);
    }

    @Override
    public void onEventMainThread(LoginEvent event) {
        switch (event.getEventType()){
            case LoginEvent.onSignInSuccess:
                onSignInSuccess();
                break;
            case LoginEvent.onSignUpError:
                onSignUpError(event.getErrorMessage());
                break;
            case LoginEvent.onSignUpSuccess:
                onSignUpSuccess();
                break;
            case LoginEvent.onFailedToRecoverSession:
                onFailedToRecoverSession();
                break;
        }
    }

    private void onFailedToRecoverSession() {
        
    }

    private void onSignInSuccess(){
        if (loginView != null){
            loginView.navigateToMainScreen();
        }
    }

    private void onSignUpSuccess(){
        if (loginView != null){
            loginView.newUserSuccess();
        }
    }

    private void onSignInError(String error){
        if (loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.loginError(error);
        }
    }

    private void onSignUpError(String error){
        if (loginView != null){
            loginView.hideProgress();
            loginView.enableInputs();
            loginView.newUserError(error);
        }
    }
}

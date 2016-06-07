package edu.galileo.android.androidchat.login;

import edu.galileo.android.androidchat.login.events.LoginEvent;

/**
 * Created by carlos.gomez on 07/06/2016.
 */
public interface LoginPresenter {
    //hay que registrar el presentador al bus para escuchar por eventos
    void onCreate();

    //este presentador estará vinculado a la vista, entonces la vista será una actividad y es posible
    //que tenga un memory leak, entonces al destruir la vista destruyo también la variable del presentador
    void onDestroy();

    void checkForAuthenticatedUser();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);

    //recepción de datos.
    // Está asociado con mi librería. Si ya no está asociado con la librería entonces puedo mantener el
    // mismo nombre y si lo quiero modificar lo hago aquí en la interface
    void onEventMainThread(LoginEvent event);
}

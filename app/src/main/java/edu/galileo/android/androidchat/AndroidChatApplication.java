package edu.galileo.android.androidchat;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by carlos.gomez on 07/06/2016.
 */
public class AndroidChatApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setupFirebase();
    }

    private void setupFirebase() {
        // Firebase.setAndroidContext(this); // se inicializa firebase
        FirebaseDatabase.getInstance().setPersistenceEnabled(true); // características offline activadas
    }
}

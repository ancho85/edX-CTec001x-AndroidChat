package edu.galileo.android.androidchat.domain;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by carlos.gomez on 07/06/2016.
 * login with google account carlos85honig@gmail.com at console.firebase.google.com
 * project is edx-ctec001x-androidchat
 */
public class FirebaseHelper {
    private DatabaseReference dataReference;
    private final static String SEPARATOR = "___";
    private final static String CHATS_PATH = "chats";
    private final static String USERS_PATH = "users";
    private final static String CONTACTS_PATH = "contacts";
    private final static String FIREBASE_URL = "https://edx-ctec001x-androidchat.firebaseio.com/";

    private static class SingletonHolder{
        private static final FirebaseHelper INSTANCE = new FirebaseHelper();
    }
    public static FirebaseHelper getInstance(){
        // Una sola instancia en toda la app
        return SingletonHolder.INSTANCE;
    }

    public FirebaseHelper() {
        this.dataReference = FirebaseDatabase.getInstance().getReferenceFromUrl(FIREBASE_URL);
    }

    public DatabaseReference getDataReference() {
        return dataReference;
    }

    public String getAuthUserEmail(){
        AuthData authData = dataReference.getAuth();
        String email = null;
        if (authData != null){
            Map<String, Object> providerData = authData.getProviderData();
            email = providerData.get("email").toString();
        }
        return email;
    }

    public FirebaseDatabase getUserReference(String email){
        FirebaseDatabase userReference = null;
        if (email != null){
            String emailKey = email.replace(".", "_"); //FirebaseDatabase no permite varios caracteres en la ruta, el punto por ej.
            userReference = dataReference.getRoot().child(USERS_PATH).child(emailKey);
        }
        return userReference;
    }

    public FirebaseDatabase getMyUserReference(){ //obtener referencia a MI usuario
        return getUserReference(getAuthUserEmail());
    }

    public FirebaseDatabase getContactsReference(String email){
        return getUserReference(email).child(CONTACTS_PATH);
    }

    public FirebaseDatabase getMyContactsReference(){
        return getContactsReference(getAuthUserEmail());
    }

    public FirebaseDatabase getOneContactReference(String mainEmail, String childEmail){
        String childKey = childEmail.replace(".","_");
        return getUserReference(mainEmail).child(CONTACTS_PATH).child(childKey);
    }

    public FirebaseDatabase getChatsReference(String receiver){
        String keySender = getAuthUserEmail().replace(".","_");
        String keyReceiver = receiver.replace(".","_");

        String keyChat = keySender + SEPARATOR + keyReceiver;
        if (keySender.compareTo(keyReceiver) > 0){ // para tener la clave siempre en orden alfabético
            keyChat = keyReceiver + SEPARATOR + keySender;
        }
        return dataReference.getRoot().child(CHATS_PATH).child(keyChat);
    }

    public void changeUserConnectionStatus(boolean online) {
        if (getMyUserReference() != null){
            Map<String, Object> updates = new HashMap<String, Object>();
            updates.put("online", online); //a la clave se le asigna el boolean recibido
            getMyUserReference().updateChildren(updates);
            notifyContactsOfConnectionChange(online);
        }
    }

    public void notifyContactsOfConnectionChange(boolean online) {
        notifyContactsOfConnectionChange(online, false);
    }

    public void signOff(){
        notifyContactsOfConnectionChange(User.OFFLINE, true);
    }

    private void notifyContactsOfConnectionChange(final boolean online, final boolean signoff) {
        final String myEmail = getAuthUserEmail();
        getMyContactsReference().addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child: dataSnapshot.getChildren()){
                    String email = child.getKey();
                    FirebaseDatabase reference = getOneContactReference(email, myEmail);
                    reference.setValue(online);
                }
                if (signoff){
                    dataReference.unauth();
                }
            }

            @Override
            public void onCancelled(DatabaseError firebaseError) {}
        });

    }
}

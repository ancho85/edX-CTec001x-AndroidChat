package edu.galileo.android.androidchat.contactlist.ui.adapters;

import edu.galileo.android.androidchat.entities.User;

/**
 * Created by carlos.gomez on 09/06/2016.
 */
public interface OnItemClickListener {
    void onItemClick(User user); //para ver chats
    void onItemLongClick(User user); //para eliminar contactos
}

package edu.galileo.android.androidchat.lib;

/**
 * Created by carlos.gomez on 07/06/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}

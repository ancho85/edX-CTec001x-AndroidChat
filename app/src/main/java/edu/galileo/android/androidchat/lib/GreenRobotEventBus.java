package edu.galileo.android.androidchat.lib;

/**
 * Created by carlos.gomez on 07/06/2016.
 */
public class GreenRobotEventBus implements EventBus{
    de.greenrobot.event.EventBus eventBus;

    private static class SingletonHolder {
        private static final GreenRobotEventBus INSTANCE = new GreenRobotEventBus();
    }

    public static GreenRobotEventBus getInstance(){
        //una sola instancia en toda la app
        return SingletonHolder.INSTANCE;
    }

    public GreenRobotEventBus() {
        //el bus por defecto en el constructor y se llama en el SingletonHolder arriba (new Green...)
        this.eventBus = de.greenrobot.event.EventBus.getDefault();
    }

    @Override
    public void register(Object subscriber) {
        eventBus.register(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        eventBus.unregister(subscriber);
    }

    @Override
    public void post(Object event) {
        eventBus.post(event);
    }
}
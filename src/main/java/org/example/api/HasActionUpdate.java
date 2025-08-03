package org.example.api;

public interface HasActionUpdate<T> {

    boolean update(float delta,ActionCallback<T> actionCallback);
}

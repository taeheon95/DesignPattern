package org.example.observer.pull;

public interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();

    Integer getValue();

    String getStr();
}

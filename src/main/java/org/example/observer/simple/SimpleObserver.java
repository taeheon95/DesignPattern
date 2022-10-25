package org.example.observer.simple;

public class SimpleObserver implements Observer {

    private int value;
    private final Subject simpleSubject;

    public SimpleObserver(Subject simpleSubject) {
        this.simpleSubject = simpleSubject;
        simpleSubject.registerObserver(this);
    }

    @Override
    public void update(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
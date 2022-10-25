package org.example.observer.pull;

import java.util.ArrayList;
import java.util.List;

public class PullSubject implements Subject {

    private Integer value;
    private String str;
    private final List<Observer> observers;

    public PullSubject() {
        this.value = 0;
        this.str = "";
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getStr() {
        return str;
    }

    public void setValue(Integer value) {
        this.value = value;
        notifyObservers();
    }

    public void setStr(String str) {
        this.str = str;
        notifyObservers();
    }
}

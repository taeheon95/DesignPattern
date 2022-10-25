package org.example.observer.pull;

public class PullStrObserver implements Observer {

    private String value;
    private final Subject subject;

    public PullStrObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        this.value = subject.getStr();
    }

    public String getValue() {
        return value;
    }
}

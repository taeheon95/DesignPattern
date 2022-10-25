package org.example.observer.pull;

public class PullIntObserver implements Observer {
    private Integer value;

    private final Subject subject;

    public PullIntObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        this.value = subject.getValue();
    }

    public Integer getValue() {
        return value;
    }
}

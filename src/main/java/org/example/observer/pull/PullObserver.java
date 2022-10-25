package org.example.observer.pull;

public class PullObserver implements Observer {
    private Integer value;
    private String str;
    private final Subject subject;

    public PullObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update() {
        this.value = subject.getValue();
        this.str = subject.getStr();
    }

    public Integer getValue() {
        return value;
    }

    public String getStr() {
        return str;
    }
}

package org.example.observer.pull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PullObserverTest {

    PullSubject subject;
    PullObserver pullObserver;
    PullIntObserver intObserver;
    PullStrObserver strObserver;

    @BeforeEach
    public void setUpEach() {
        subject = new PullSubject();
        pullObserver = new PullObserver(subject);
        intObserver = new PullIntObserver(subject);
        strObserver = new PullStrObserver(subject);
    }

    @Test
    @DisplayName("풀 방식 옵저버 테스트")
    public void pullObserverTest() {
        subject.setValue(10);
        subject.setStr("test");

        assertThat(pullObserver.getValue()).isEqualTo(10);
        assertThat(pullObserver.getStr()).isEqualTo("test");
        assertThat(pullObserver.getStr()).isEqualTo(strObserver.getValue());
        assertThat(pullObserver.getValue()).isEqualTo(intObserver.getValue());
    }

    @Test
    @DisplayName("풀 방식 옵저버 제거 테스트")
    public void pullObserverRemoveTest() {
        subject.setValue(10);
        subject.setStr("test");

        assertThat(pullObserver.getValue()).isEqualTo(10);
        assertThat(pullObserver.getStr()).isEqualTo("test");
        assertThat(pullObserver.getStr()).isEqualTo(strObserver.getValue());
        assertThat(pullObserver.getValue()).isEqualTo(intObserver.getValue());

        subject.removeObserver(pullObserver);
        subject.setValue(20);
        subject.setStr("changed");

        assertThat(pullObserver.getValue()).isNotEqualTo(intObserver.getValue());
        assertThat(pullObserver.getStr()).isNotEqualTo(strObserver.getValue());
    }
}
package org.example.observer.simple;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SimpleObserverTest {

    SimpleSubject subject;
    List<SimpleObserver> observers = new ArrayList<>();

    @BeforeEach
    public void setUpEach() {
        subject = new SimpleSubject();
        observers.add(new SimpleObserver(subject));
        observers.add(new SimpleObserver(subject));
        observers.add(new SimpleObserver(subject));
        observers.add(new SimpleObserver(subject));
    }

    @Test
    @DisplayName("옵저버 패턴 테스트")
    public void observerSimpleTest() {
        // when
        subject.setValue(10);
        // then
        assertThat(observers.get(0).getValue()).isEqualTo(10);
        assertThat(observers.get(1).getValue()).isEqualTo(10);
        assertThat(observers.get(2).getValue()).isEqualTo(10);
        assertThat(observers.get(3).getValue()).isEqualTo(10);
    }

    @Test
    @DisplayName("옵저버 패턴 삭제 테스트")
    public void observerRemoveTest() {
        subject.setValue(10);
        // then
        assertThat(observers.get(0).getValue()).isEqualTo(10);
        assertThat(observers.get(1).getValue()).isEqualTo(10);
        assertThat(observers.get(2).getValue()).isEqualTo(10);
        assertThat(observers.get(3).getValue()).isEqualTo(10);

        subject.removeObserver(observers.get(0));
        subject.setValue(20);

        assertThat(observers.get(0).getValue()).isEqualTo(10);
        assertThat(observers.get(1).getValue()).isEqualTo(20);
        assertThat(observers.get(2).getValue()).isEqualTo(20);
        assertThat(observers.get(3).getValue()).isEqualTo(20);
    }
}
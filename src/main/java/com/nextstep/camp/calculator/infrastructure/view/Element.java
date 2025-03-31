package com.nextstep.camp.calculator.infrastructure.view;

public interface Element<T> {
    void action();
    String getLabel();
    T getValue();
}


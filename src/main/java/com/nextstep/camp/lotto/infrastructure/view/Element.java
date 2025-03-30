package com.nextstep.camp.lotto.infrastructure.view;

public interface Element<T> {
    void action();
    String getLabel();
    T getValue();
}


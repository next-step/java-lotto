package com.nextstep.camp.common.view;

public interface Element<T> {
    void action();
    String getLabel();
    T getValue();
}


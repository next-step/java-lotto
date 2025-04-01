package com.nextstep.camp.common.view;

public interface Element<T> {
    T action();
    String getLabel();
    T getValue();
}


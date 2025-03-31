package com.nextstep.camp.calculator.infrastructure.view.component;

import com.nextstep.camp.calculator.infrastructure.view.Element;

public abstract class AbstractResult<T> implements Element<T> {
    protected final T value;

    protected AbstractResult(T value) {
        this.value = value;
    }

    @Override
    public abstract void action();
}

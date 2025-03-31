package com.nextstep.camp.common.view.component;

import com.nextstep.camp.common.view.Element;

public abstract class AbstractResult<T> implements Element<T> {
    protected final T value;

    protected AbstractResult(T value) {
        this.value = value;
    }

    @Override
    public abstract void action();
}

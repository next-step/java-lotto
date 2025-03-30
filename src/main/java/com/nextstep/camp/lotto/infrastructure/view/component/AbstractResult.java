package com.nextstep.camp.lotto.infrastructure.view.component;

import com.nextstep.camp.lotto.infrastructure.view.Element;

public abstract class AbstractResult<T> implements Element<T> {
    protected final T value;

    protected AbstractResult(T value) {
        this.value = value;
    }

    @Override
    public abstract void action();
}

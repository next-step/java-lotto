package com.nextstep.camp.common.view.component;

import com.nextstep.camp.common.strategy.InputStrategy;
import com.nextstep.camp.common.view.Element;

import java.util.Scanner;
import java.util.stream.Stream;

public abstract class AbstractInput<T> implements Element<T> {
    private final InputStrategy<T> inputStrategy;
    protected T value;

    public AbstractInput(InputStrategy<T> inputStrategy) {
        this.inputStrategy = inputStrategy;
    }

    @Override
    public T action() {
        requestInput();
        return value;
    }

    private void requestInput() {
        System.out.println(getLabel());
        this.value = readValidValue();
    }

    private T readValidValue() {
        return inputStrategy.read();
    }

    public T getValue() {
        return value;
    }
}

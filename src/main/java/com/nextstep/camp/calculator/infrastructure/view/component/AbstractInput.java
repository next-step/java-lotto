package com.nextstep.camp.calculator.infrastructure.view.component;

import com.nextstep.camp.calculator.infrastructure.view.Element;

import java.util.Scanner;
import java.util.stream.Stream;

public abstract class AbstractInput<T> implements Element<T> {
    protected String untypedValue;
    protected T value;

    private static final String ERROR_MESSAGE = "잘못된 입력입니다. 다시 입력해주세요.";
    private final Scanner scanner;

    public AbstractInput(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void action() {
        requestInput();
    }

    private void requestInput() {
        System.out.println(getLabel());
        this.untypedValue = readValidValue();
    }

    private String readValidValue() {
        return Stream.generate(scanner::nextLine)
            .filter(answer -> {
                if (isValid(answer)) {
                    return true;
                }
                System.out.println(ERROR_MESSAGE);
                return false;
            })
            .findFirst()
            .orElseThrow();
    }

    protected abstract boolean isValid(String value);
}

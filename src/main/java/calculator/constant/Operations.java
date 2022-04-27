package calculator.constant;

import calculator.domain.operation.*;
import calculator.exception.InvalidSignException;

import java.util.stream.Stream;

public enum Operations {

    ADD("+", new AddOperation()),
    MINUS("-", new MinusOperation()),
    DIVISION("/", new DivideOperation()),
    MULTIPLICATION("*", new MultiplyOperation());

    private String sign;
    private Operation operation;

    Operations(String sign, Operation operation) {
        this.sign = sign;
        this.operation = operation;
    }

    public static Operations findBySign(String sign) {
        return Stream.of(Operations.values())
                .filter(operations -> operations.sign.equals(sign))
                .findAny()
                .orElseThrow(InvalidSignException::new);
    }

    public Operation operation() {
        return this.operation;
    }
}

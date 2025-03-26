package calculator.domain;

import java.util.Arrays;

public enum Operator {
    ADDITION("+", OperatorFunction::add),
    SUBTRACTION("-", OperatorFunction::subtract),
    MULTIPLICATION("*", OperatorFunction::multiple),
    DIVISION("/", OperatorFunction::divide);

    private final String signature;
    private final OperatorFunction function;

    Operator(String signature, OperatorFunction function) {
        this.signature = signature;
        this.function = function;
    }

    public static Operator of(String signature) {
        return Arrays.stream(values())
                .filter(operator -> operator.signature.equals(signature))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("operator is not allowed except +,-,*,/"));
    }

    public long execute(long number1, long number2) {
        return function.execute(number1, number2);
    }

}

package calculator.operator;

import java.util.Map;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OperatorType {

    ADD("+", new AddOperator()),
    MINUS("-", new MinusOperator()),
    MULTIPLY("*", new MultiplyOperator()),
    DIVIDE("/", new DivideOperator());

    private final String operatorIndicator;
    private final IntBinaryOperator operator;
    private static final Map<String, OperatorType> BY_OPERATOR_STRING = Stream.of(values())
            .collect(Collectors.toMap(operatorType -> operatorType.operatorIndicator, Function.identity()));

    OperatorType(String operatorIndicator, IntBinaryOperator operator) {
        this.operatorIndicator = operatorIndicator;
        this.operator = operator;
    }

    public static OperatorType from(String input) {
        if (!BY_OPERATOR_STRING.containsKey(input)) {
            throw new IllegalArgumentException("wrong operator type");
        }
        return BY_OPERATOR_STRING.get(input);
    }

    public IntBinaryOperator getOperator() {
        return operator;
    }
}

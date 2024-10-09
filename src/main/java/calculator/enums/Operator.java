package calculator.enums;

import calculator.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", new PlusOperator()),
    MINUS("-", new MinusOperator()),
    MULTIPLY("*", new MultiplyOperator()),
    DIVIDE("/", new DivideOperator());

    private final String operator;
    private final OperatorMethod operatorClass;

    Operator(String operator, OperatorMethod operatorClass) {
        this.operator = operator;
        this.operatorClass = operatorClass;
    }

    public String getOperator() {
        return operator;
    }

    public OperatorMethod getOperatorClass() {
        return operatorClass;
    }

    public static List<String> getOperators() {
        return Arrays.stream(Operator.values())
                .map(Operator::getOperator)
                .collect(Collectors.toUnmodifiableList());
    }

    public static OperatorMethod from(String operator) {
        return Arrays.stream(Operator.values())
                .filter(s -> operator.equals(s.operator))
                .findAny()
                .orElseThrow(() -> new IllegalStateException("해당하는 operator가 존재하지 않습니다."))
                .getOperatorClass();
    }
}

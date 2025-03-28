package calculator.domain;

import calculator.AddStrategy;
import calculator.DivideStrategy;
import calculator.MultiplyStrategy;
import calculator.OperateStrategy;
import calculator.SubtractStrategy;
import calculator.domain.exception.UnexpectedOperatorException;
import java.util.Arrays;

public enum Operator {

    PLUS("+", new AddStrategy()),
    MINUS("-", new SubtractStrategy()),
    MULTIPLY("*", new MultiplyStrategy()),
    DIVIDE("/", new DivideStrategy());

    private final String operator;
    private final OperateStrategy operateStrategy;

    Operator(String operator, OperateStrategy operateStrategy) {
        this.operator = operator;
        this.operateStrategy = operateStrategy;
    }

    public static Operator from(String operator) {
        return Arrays.stream(values())
            .filter(e -> e.operator.equals(operator))
            .findFirst()
            .orElseThrow(UnexpectedOperatorException::new);
    }

    public Number apply(Number left, Number right) {
        return this.operateStrategy.apply(left, right);
    }
}

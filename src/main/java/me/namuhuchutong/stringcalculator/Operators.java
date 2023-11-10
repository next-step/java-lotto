package me.namuhuchutong.stringcalculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operators {

    private static final String OPERATOR_PATTERN = "[^+\\-*/]";
    private static final int OPERATOR_SIZE = 1;

    private final Queue<String> values;

    public static Operators from(String input) {
        Queue<String> collect = Stream.of(input.split(OPERATOR_PATTERN))
                                      .filter(isOnlyOneLength())
                                      .collect(Collectors.toCollection(LinkedList::new));
        return new Operators(collect);
    }

    private static Predicate<String> isOnlyOneLength() {
        return operator -> operator.length() == OPERATOR_SIZE;
    }

    public Operators(Queue<String> values) {
        validateOperators(values);
        this.values = values;
    }

    private void validateOperators(Queue<String> values) {
        if (values.size() == 0) {
            throw new IllegalArgumentException("사칙연산자만 입력할 수 있습니다.");
        }
    }

    public int calculate(Operands operands) {
        validateExpression(operands);
        while(!this.values.isEmpty()) {
            Expression expression = new Expression(
                    this.values.poll(),
                    operands.getOperand(),
                    operands.getOperand());
            int result = Calculator.calculate(expression);
            operands.push(result);
        }
        return operands.getResult();
    }

    private void validateExpression(Operands operands) {
        if (isValidExpression(operands)) {
            throw new IllegalArgumentException("식이 올바르지 않습니다.");
        }
    }

    private boolean isValidExpression(Operands operands) {
        return Math.abs(this.values.size() - operands.getOperandsSize()) != 1;
    }
}

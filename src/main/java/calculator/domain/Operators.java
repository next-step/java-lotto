package calculator.domain;

import static java.util.Arrays.stream;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Operators {

    private final String [] operators;

    private static final String INVALID_OPERATOR = "올바른 연산기호가 아닙니다.";


    public Operators(String[] operators) {
        if(isNull(operators) || hasInvalidElement(operators)) {
            throw new IllegalArgumentException(INVALID_OPERATOR);
        }
        this.operators = operators;
    }

    private boolean hasInvalidElement(String [] operators) {
        if(isEmpty(operators)) {
            return false;
        }
        return stream(operators)
                .noneMatch(OperatorsConstant::isProperSymbol);
    }

    private boolean isEmpty(String [] operators) {
        return operators.length == 0;
    }

    private boolean isNull(String [] operators) {
        return operators == null;
    }

    public Queue<String> operators() {
        Queue<String> numbers = new LinkedList<>();
        for (String operator : this.operators) {
            numbers.offer(operator);
        }
        return numbers;
    }

    @Override
    public String toString() {
        return "Operators{" +
                "operators=" + Arrays.toString(operators) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operators operators1 = (Operators) o;
        return Arrays.equals(operators, operators1.operators);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(operators);
    }
}

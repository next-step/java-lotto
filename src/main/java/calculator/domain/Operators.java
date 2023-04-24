package calculator.domain;

import static java.util.Arrays.stream;

import calculator.domain.constant.OperatorsConstant;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Operators {

    private static final String INVALID_OPERATOR = "올바른 연산기호가 아닙니다.";
    private final List<String> operators;


    public Operators(List<String> operators) {
        if(isNull(operators) || hasInvalidElement(operators)) {
            throw new IllegalArgumentException(INVALID_OPERATOR);
        }
        this.operators = operators;
    }

    private boolean hasInvalidElement(List<String> operators) {
        if(operators.isEmpty()) {
            return false;
        }
        return operators.stream()
                .noneMatch(OperatorsConstant::isProperSymbol);
    }

    private boolean isNull(List<String> operators) {
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
                "operators=" + operators +
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
        return Objects.equals(operators, operators1.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operators);
    }
}

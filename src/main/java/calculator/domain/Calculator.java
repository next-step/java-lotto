package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calculator {

    private static final String NOT_COMPUTABLE_SIZE_MESSAGE = "계산이 불가능한 식 입니다. 숫자가 연산자보다 하나 더 많아야합니다.";

    private final Numbers numbers;
    private final Operators operators;

    public Calculator(final Numbers numbers, final Operators operators) {
        validateComputableSize(numbers, operators);
        this.numbers = numbers;
        this.operators = operators;
    }

    public Calculator(final List<String> formula) {
        this(Numbers.of(extractEvenIndexString(formula)), Operators.of(extractOddIndexString(formula)));
    }

    private void validateComputableSize(Numbers numbers, Operators operators) {
        if (numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException(NOT_COMPUTABLE_SIZE_MESSAGE);
        }
    }

    private static List<String> extractEvenIndexString(List<String> formula) {
        return IntStream.range(0, formula.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(formula::get)
                .collect(Collectors.toList());
    }

    private static List<String> extractOddIndexString(List<String> formula) {
        return IntStream.range(0, formula.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(formula::get)
                .collect(Collectors.toList());
    }

    public int doCalculations() {
        int result = operators.operate(0, numbers.get(0), numbers.get(1));
        for (int i = 1; i < operators.size(); i++) {
            result = operators.operate(i, result, numbers.get(i + 1));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(numbers, that.numbers) && Objects.equals(operators, that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, operators);
    }
}

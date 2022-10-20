package calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
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
        this(Numbers.from(extract(formula, isEvenIndex())), Operators.from(extract(formula, isOddIndex())));
    }

    private void validateComputableSize(Numbers numbers, Operators operators) {
        if (numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException(NOT_COMPUTABLE_SIZE_MESSAGE);
        }
    }

    private static List<String> extract(List<String> formula, ExtractConditional extractConditional) {
        return IntStream.range(0, formula.size())
                .filter(extractConditional::check)
                .mapToObj(formula::get)
                .collect(Collectors.toList());
    }

    private static ExtractConditional isEvenIndex() {
        return (number) -> number % 2 == 0;
    }

    private static ExtractConditional isOddIndex() {
        return (number) -> number % 2 == 1;
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

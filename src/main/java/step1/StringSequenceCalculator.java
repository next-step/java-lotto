package step1;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class StringSequenceCalculator {
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATORS = Map.of(
            "+", Integer::sum,
            "-", (num1, num2) -> num1 - num2,
            "*", (num1, num2) -> num1 * num2,
            "/", (num1, num2) -> num1 / num2
    );
    private final List<Integer> numbers;
    private final List<String> operators;

    public StringSequenceCalculator(List<Integer> numbers, List<String> operators) {
        validate(numbers, operators);
        this.numbers = numbers;
        this.operators = operators;
    }

    private void validate(List<Integer> numbers, List<String> operators) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("숫자가 없습니다.");
        }
        if (operators.isEmpty()) {
            throw new IllegalArgumentException("연산자가 없습니다.");
        }
    }

    public int calculate() {
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = calculate(result, numbers.get(i + 1), operators.get(i));
        }
        return result;
    }

    private int calculate(int num1, int num2, String operator) {
        return OPERATORS.get(operator).apply(num1, num2);
    }
}

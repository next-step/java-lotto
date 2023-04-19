package step1;

import java.util.List;

public class StringSequenceCalculator {
    private final List<Integer> numbers;
    private final List<Operator> operators;

    public StringSequenceCalculator(List<Integer> numbers, List<Operator> operators) {
        validate(numbers, operators);
        this.numbers = numbers;
        this.operators = operators;
    }

    private void validate(List<Integer> numbers, List<Operator> operators) {
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

    private int calculate(int num1, int num2, Operator operator) {
        return operator.calculate(num1, num2);
    }
}

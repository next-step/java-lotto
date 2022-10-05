package stringcalculator;

import java.util.List;
import java.util.Objects;

public class CalculatorRequest {

    private final List<Integer> numbers;
    private final List<ArithmeticOperator> operators;

    public CalculatorRequest(List<Integer> numbers, List<ArithmeticOperator> operators) {
        validate(numbers, operators);
        this.numbers = numbers;
        this.operators = operators;
    }

    private void validate(List<Integer> numbers, List<ArithmeticOperator> operators) {
        if (numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException("연산할 숫자의 개수는 연산자의 개수보다 1개 많아야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<ArithmeticOperator> getOperators() {
        return operators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorRequest that = (CalculatorRequest) o;
        return Objects.equals(numbers, that.numbers) && Objects.equals(operators, that.operators);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, operators);
    }

}

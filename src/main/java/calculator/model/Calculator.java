package calculator.model;

import java.util.Collections;
import java.util.List;

public class Calculator {

    private final List<Number> numbers;

    private final List<Operator> operators;

    public Calculator(List<Number> numbers, List<Operator> operators) {
        validate(numbers, operators);
        this.numbers = Collections.unmodifiableList(numbers);
        this.operators = Collections.unmodifiableList(operators);
    }

    private void validate(List<Number> numbers, List<Operator> operators) {
        if (isEmptyNumber(numbers) || isInvalidSizeWithNumbersAndOperators(numbers, operators)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isInvalidSizeWithNumbersAndOperators(List<Number> numbers, List<Operator> operators) {
        return (numbers.size() - 1) != operators.size();
    }

    private boolean isEmptyNumber(List<Number> numbers) {
        return numbers.size() == 0;
    }

    public Number calculate() {
        Number resultNumber = numbers.get(0);

        for (int index = 0; index < operators.size(); index++) {
            Operator operator = operators.get(index);
            Number number = numbers.get(index + 1);
            resultNumber = operator.calculate(resultNumber, number);
        }

        return resultNumber;
    }

}

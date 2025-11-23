package calculator.model;

import java.util.List;

public class Calculator {
    private final Numbers numbers;
    private final Operators operators;

    public Calculator(List<Number> numbers, List<Operator> operators) {
        this(new Numbers(numbers), new Operators(operators));
    }

    public Calculator(Numbers numbers, Operators operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public Number run() {
        Number result = numbers.initResult();
        for (int i = 0; i <= operators.size() - 1; i++) {
            result = operators.operate(i, result, numbers.nextNumber(i + 1));
        }
        return result;
    }
}

package StringCalculator;

import java.util.List;

public class MathExpression {
    private final List<Integer> numbers;
    private final List<String> operations;

    MathExpression(List<Integer> numbers, List<String> operations) {
        this.numbers = numbers;
        this.operations = operations;
    }

    public Boolean numbersContains(List<Integer> contains) {
        return numbers.containsAll(contains);
    }

    public Boolean operationsContains(List<String> contains) {
        return operations.containsAll(contains);
    }
}

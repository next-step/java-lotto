package calculator;

public class Calculator {

    private final Numbers numbers;
    private final Operators operations;

    public Calculator(String input) {
        NumberOperatorParser parser = new NumberOperatorParser(input);
        numbers = parser.getNumbers();
        operations = parser.getOperators();
    }

    public int calculate() {
        int sum = numbers.nextNumber();

        for (int i = 0; i < numbers.size() - 1; i++) {
            Operator operator = operations.nextOperation();
            sum = operator.apply(sum, numbers.nextNumber());
        }
        return sum;
    }
}

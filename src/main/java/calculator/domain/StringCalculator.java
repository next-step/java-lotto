package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {
    private final static int START = 0;
    private final Expression expression;

    public StringCalculator(String input) {
        this.expression = new Expression(input);
    }

    public int getResult() {
        List<OperationStrategy> operationStrategies = expression.getOperations();
        List<Integer> numbers = expression.getNumbers();

        return calculate(operationStrategies, numbers);
    }

    private int calculate(List<OperationStrategy> operationStrategies, List<Integer> numbers)
    {
        int pointer = START;
        int sum = numbers.get(pointer++);

        for(OperationStrategy operationStrategy: operationStrategies) {
            sum = operationStrategy.operate(sum, numbers.get(pointer++));
        }

        return sum;
    }


}

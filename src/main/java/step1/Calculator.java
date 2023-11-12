package step1;

import java.util.List;

public class Calculator {

    private final List<Integer> numbers;
    private final List<Operator> operators;

    public Calculator(List<Integer> numbers, List<Operator> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public int calculate() {
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            Integer rightNumber = numbers.get(i + 1);

            result = operator.apply(result, rightNumber);
        }
        return result;
    }
}

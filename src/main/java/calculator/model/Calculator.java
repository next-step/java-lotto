package calculator.model;

import java.util.List;

public class Calculator {

    public int calculate(List<Integer> numbers, List<Operator> operators) {
        int result = numbers.get(0);
        int size = operators.size();
        for (int i = 0; i < size; i++) {
            Operator operator = operators.get(i);
            result = operator.calculate(result, numbers.get(i + 1));
        }
        return result;
    }
}

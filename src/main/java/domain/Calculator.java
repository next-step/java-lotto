package domain;

import java.util.List;

public class Calculator {

    public int calculate(List<Integer> numbers, List<Operator> operators) {
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            result = operator.calculate(result, numbers.get(i+1));
        }
        return result;
    }
}


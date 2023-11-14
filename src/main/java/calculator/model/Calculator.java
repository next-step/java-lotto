package calculator.model;

import calculator.model.constants.Operators;

import java.util.List;

public class Calculator {
    List<Integer> numbers;
    List<String> operators;

    public Calculator(InputNumber numbers, Operator operators) {
        this.numbers = numbers.numbers();
        this.operators = operators.operators();
    }

    public int calculate() {
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = Operators.calculate(operators.get(i), result, numbers.get(i + 1));
        }
        return result;
    }

}

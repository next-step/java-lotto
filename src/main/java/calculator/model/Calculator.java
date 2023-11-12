package calculator.model;

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
            result = getResult(result, i);
        }
        return result;
    }

    private int getResult(int result, int index) {
        if ("+".equals(operators.get(index))) {
            return addition(result, numbers.get(index + 1));
        }
        if ("-".equals(operators.get(index))) {
            return subtraction(result, numbers.get(index + 1));
        }
        if ("*".equals(operators.get(index))) {
            return multiplication(result, numbers.get(index + 1));
        }
        return division(result, numbers.get(index + 1));
    }

    private int addition(int left, int right) {
        return left + right;
    }

    private int subtraction(int left, int right) {
        return left - right;
    }

    private int multiplication(int left, int right) {
        return left * right;
    }

    private int division(int left, int right) {
        return left / right;
    }
}

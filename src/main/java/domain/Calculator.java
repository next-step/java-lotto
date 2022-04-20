package domain;

import exception.InvalidOperatorException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private List<String> queue;

    public Calculator(String[] target) {
        queue = new ArrayList<>(Arrays.asList(target));
    }

    public int calculate() {
        int result = Integer.parseInt(queue.get(0)); // queue.size() == 1

        int num1;
        String operator;
        int num2;
        while (queue.size() != 1) {
            num1 = Integer.parseInt(queue.remove(0));
            operator = queue.remove(0);
            num2 = Integer.parseInt(queue.remove(0));

            result = calculate(createOperator(operator), num1, num2);

            queue.add(0, String.valueOf(result));
        }

        return result;
    }

    private Operator createOperator(String operator) {
        if ("+".equals(operator)) {
            return new PlusOperator();
        }

        if ("-".equals(operator)) {
            return new MinusOperator();
        }

        if ("*".equals(operator)) {
            return new MultiplyOperator();
        }

        if ("/".equals(operator)) {
            return new DivideOperator();
        }

        throw new InvalidOperatorException(operator);
    }

    private int calculate(Operator operator, int num1, int num2) {
        return operator.calculate(num1, num2);
    }
}

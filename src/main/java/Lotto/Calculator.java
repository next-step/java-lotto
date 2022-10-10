package Lotto;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    static int calculate(String valueText) {
        String[] values = valueText.split(" ");
        List<Integer> numbers = toNumbers(values);
        List<Operator> operators = toOperators(values);
        int index = 0;
        int result = numbers.get(0);
        for (Operator operator : operators) {
            int num1 = numbers.get(index);
            int num2 = numbers.get(index+1);
            result = operator.operate(num1, num2);
            index++;
        }

        return result;
    }

    private static List<Integer> toNumbers(String[] values) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (i % 2 == 0) {
                numbers.add(Integer.parseInt(values[i]));
            }
        }

        return numbers;
    }

    private static List<Operator> toOperators(String[] values) {
        List<Operator> operators = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (i % 2 != 0) {
                operators.add(new Operator(values[i]));
            }
        }

        return operators;
    }
}

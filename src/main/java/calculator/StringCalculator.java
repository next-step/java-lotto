package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 또는 공백이 들어옴");
        }
        List<String> operands = new ArrayList<>(Arrays.asList(input.split(" ")));
        while (operands.size() > 1) {
            Operand left = new Operand(operands.remove(0));
            Operator operator = Operator.from(operands.remove(0));
            Operand right = new Operand(operands.remove(0));

            String result = String.valueOf(operator.compute(left, right));
            operands.add(0, result);
        }

        return Integer.parseInt(operands.get(0));
    }
}

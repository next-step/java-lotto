package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    public static int calculate(String input) {
        assertInput(input);

        List<String> operands = new ArrayList<>(Arrays.asList(input.split(" ")));
        while (operands.size() > 1) {
            int result = calculateOne(operands);
            operands.add(0, String.valueOf(result));
        }

        return Integer.parseInt(operands.get(0));
    }

    private static void assertInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 또는 공백이 들어옴");
        }
    }

    private static int calculateOne(List<String> operands) {
        Operand left = new Operand(operands.remove(0));
        Operator operator = Operator.from(operands.remove(0));
        Operand right = new Operand(operands.remove(0));

        return operator.compute(left, right);
    }
}

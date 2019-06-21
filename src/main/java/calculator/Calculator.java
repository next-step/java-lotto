package calculator;

import java.util.List;

public class Calculator {
    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        Splitter splitter = new Splitter();
        List<Integer> operands = splitter.extractOperands(input);
        return sum(operands);
    }

    private int sum(List<Integer> operands) {
        int result = 0;
        for (Integer operand : operands) {
            result += operand;
        }
        return result;
    }
}

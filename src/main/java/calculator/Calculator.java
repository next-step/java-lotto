package calculator;

import java.util.List;

public class Calculator {
    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        Splitter splitter = new Splitter();
        List<Operand> operands = splitter.extractOperands(input);
        return sum(operands);
    }

    private int sum(List<Operand> operands) {
        int result = 0;
        for (Operand operand : operands) {
            result += operand.convert();
        }
        return result;
    }
}

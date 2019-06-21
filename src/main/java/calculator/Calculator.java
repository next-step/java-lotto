package calculator;

import java.util.List;

public class Calculator {
    public int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        Splitter splitter = new Splitter();
        List<Operand> inputOperands = splitter.extractOperands(input);
        Operands operands = new Operands(inputOperands);
        Operand sum = operands.sum();
        return sum.convert();
    }
}

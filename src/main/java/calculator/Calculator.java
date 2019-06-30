package calculator;

import java.util.List;

public class Calculator {
    public static int calculate(String input) {
        List<Operand> inputOperands = Splitter.extractOperands(input);

        Operands operands = new Operands(inputOperands);
        Operand result = operands.sum();

        return result.getValue();
    }
}

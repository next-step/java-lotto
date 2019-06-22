package calculator;

import java.util.List;

public class Calculator {
    public int calculate(String input) {
        Splitter splitter = new Splitter();
        List<Operand> inputOperands = splitter.extractOperands(input);

        Operands operands = new Operands(inputOperands);
        Operand result = operands.sum();

        return result.convert();
    }
}

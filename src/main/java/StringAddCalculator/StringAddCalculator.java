package StringAddCalculator;

import java.util.List;

public class StringAddCalculator {

    public static int sum(String values) {
        List<String> tokens = StringOperand.findStringOperands(values);
        return sum(tokens);
    }

    private static int sum(List<String> tokens) {
        Operand operand = new Operand(0);
        for (String token : tokens) {
            operand = operand.plus(token);
        }
        return operand.getNumber();
    }
}

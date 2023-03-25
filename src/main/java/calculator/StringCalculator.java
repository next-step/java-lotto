package calculator;

import java.util.Arrays;

public class StringCalculator {

    public int calculate(String text) {
        String delimiter = OperationParser.parseDelimiter(text);
        String defaultOperation = OperationParser.getDefaultOperation(text, delimiter);

        Operand operand = new Operand(Arrays.asList(defaultOperation.split(delimiter)));
        return operand.getOperands().stream()
                .mapToInt(i -> i)
                .sum();
    }

}

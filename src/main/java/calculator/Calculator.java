package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final Operands operands;

    public Calculator(String input, String delimiter) {
        this.operands = makeOperandsByInput(input, delimiter);
    }

    public int sumOperands() {
        return operands.sum();
    }

    private Operands makeOperandsByInput(String input, String delimiter) {
        List<Integer> values = new ArrayList<>();

        for (String value : splitOperandsByDelimiter(input, delimiter)) {
            values.add(Integer.parseInt(value));
        }

        return new Operands(values);
    }

    private String[] splitOperandsByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }
}

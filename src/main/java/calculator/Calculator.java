package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final List<Integer> values;

    public Calculator(String input, String delimiter) {
        this.values = makeOperandsByInput(input, delimiter);
    }

    private List<Integer> makeOperandsByInput(String input, String delimiter) {
        List<Integer> values = new ArrayList<>();

        for (String value : splitOperandsByDelimiter(input, delimiter)) {
            values.add(Integer.parseInt(value));
        }

        return values;
    }

    private String[] splitOperandsByDelimiter(String input, String delimiter) {
        return input.split(delimiter);
    }

    public int sum() {
        int sum = 0;

        for (int value : values) {
            sum += value;
        }

        return sum;
    }
}

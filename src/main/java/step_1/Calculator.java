package step_1;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static final String DELIMITER = ",|:";
    private final List<Number> numbers = new ArrayList<>();
    private int sum;

    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        split(input);
        return sum();
    }

    private void split(String input) {
        String[] splitInputs = input.split(DELIMITER);

        for (String splitInput : splitInputs) {
            numbers.add(new Number(splitInput));
        }
    }

    public int sum() {
        for (Number number : numbers) {
            this.sum += number.getValue();
        }

        return this.sum;
    }

    public int size() {
        return this.numbers.size();
    }
}

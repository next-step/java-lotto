package step_1;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    public static final String DELIMITER = ",|:";
    private final List<Number> numbers = new ArrayList<>();
    private int sum;

    public void split(String input) {
        if (input.isEmpty()) {
            numbers.add(new Number(0));
        } else {
            String[] splitInputs = input.split(DELIMITER);
            for (String splitInput : splitInputs) {
                numbers.add(new Number(splitInput));
            }
        }
    }

    public void sum() {
        for (Number number : numbers) {
            this.sum += number.getValue();
        }
    }

    public int count() {
        return this.sum;
    }

    public int size() {
        return this.numbers.size();
    }
}

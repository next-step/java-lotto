package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbers {
    private final List<Number> numbers = new ArrayList<>();

    public Numbers(String input) {
        String[] splitNumbers = input.split(",");

        for (String splitNumber : splitNumbers) {
            numbers.add(new Number(splitNumber));
        }
    }

    public List<Number> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}

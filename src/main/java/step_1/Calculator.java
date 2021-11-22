package step_1;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Number> number = new ArrayList<>();

    public void split(String input) {
        String[] splitInputs = input.split(",");

        for (String splitInput : splitInputs) {
            number.add(new Number(splitInput));
        }
    }

    public int size() {
        return this.number.size();
    }
}

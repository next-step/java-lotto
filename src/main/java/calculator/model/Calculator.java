package calculator.model;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    private final Deque<String> inputs;

    public Calculator(String input) {

        if (input == null) {
            throw new IllegalArgumentException();
        }

        String[] inputs = input.split(" ");
        for (String text : inputs) {
            validateInput(text);
        }

        this.inputs = new ArrayDeque<>();
        for (String str : inputs) {
            this.inputs.offer(str);
        }

    }

    private static void validateInput(String text) {
        if (text == null || text.equals("") || !PatternMatcher.validate(text)) {
            throw new IllegalArgumentException();
        }
    }

    public int result() {
        while (inputs.size() != 1) {
            inputs.offerFirst(Integer.toString(
                Operator.calculate(Integer.parseInt(inputs.pop()), inputs.pop(),
                    Integer.parseInt(inputs.pop()))));
        }
        return Integer.parseInt(inputs.pop());
    }

}

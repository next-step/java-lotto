package stringcalculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StringCalculator {

    private StringCalculator() {
        throw new UnsupportedOperationException();
    }

    public static int calculate(String expression) {
        return calculate(transform(expression));
    }

    private static Deque<String> transform(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new IllegalArgumentException();
        }

        return new LinkedList<>(List.of(expression.split(" ")));
    }

    private static int calculate(Deque<String> tokens) {
        while (tokens.size() > 1) {
            calculateFirstThree(tokens);
        }
        return Integer.parseInt(tokens.removeFirst());
    }

    private static void calculateFirstThree(Deque<String> tokens) {
        int operand1 = Integer.parseInt(tokens.removeFirst());
        Operator operator = Operator.findBySymbol(tokens.removeFirst());
        int operand2 = Integer.parseInt(tokens.removeFirst());

        String result = String.valueOf(operator.apply(operand1, operand2));
        tokens.addFirst(result);
    }
}

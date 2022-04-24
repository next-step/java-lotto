package stringcalculator;

import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import static stringcalculator.ExceptionCode.*;

public class StringCalculator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private final Stack<Integer> numbers = new Stack<>();
    private final Stack<String> operators = new Stack<>();

    public int calculate(Equation equation) {
        List<String> characters = equation.split(" ");

        for (String character : characters) {
            calculate(character);
        }

        return numbers.pop();
    }

    private void calculate(String character) {
        if (isNumber(character)) {
            push(character);
        }
        if (isOperator(character)) {
            operators.push(character);
        }
    }

    private boolean isNumber(String character) {
        return NUMBER_PATTERN.matcher(character).matches();
    }

    private void push(String character) {
        if (operators.isEmpty()) {
            numbers.push(Integer.parseInt(character));
        }
        if (!operators.isEmpty()) {
            Integer previous = numbers.pop();
            String operator = operators.pop();
            numbers.push(operate(character, previous, operator));
        }
    }

    private boolean isOperator(String character) {
        return !isNumber(character);
    }

    private int operate(String character, Integer previous, String operator) {
        int current = Integer.parseInt(character);
        if (operator.equals("+")) {
            return previous + current;
        }
        if (operator.equals("-")) {
            return previous - current;
        }
        if (operator.equals("*")) {
            return previous * current;
        }
        validateNumbers(previous, current);
        validateRemainder(previous % current);
        return previous / current;
    }

    private void validateNumbers(int previous, int current) {
        if (previous == 0 || current == 0) {
            throw new CalculatorException(NUMBER_SHOULD_NOT_BE_ZERO_WHEN_DIVIDING);
        }
    }

    private void validateRemainder(int remainder) {
        if (remainder != 0) {
            throw new CalculatorException(DIVIDE_RESULT_SHOULD_BE_INTEGER);
        }
    }
}

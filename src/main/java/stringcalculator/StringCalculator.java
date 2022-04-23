package stringcalculator;

import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import static stringcalculator.ExceptionMessage.*;

public class StringCalculator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("[0-9]+");
    private static final Stack<Integer> NUMBERS = new Stack<>();
    private static final Stack<String> OPERATORS = new Stack<>();

    public long calculate(Equation equation) {
        List<String> characters = equation.split(" ");

        for (String character : characters) {
            calculate(character);
        }

        Integer result = NUMBERS.pop();
        NUMBERS.clear();
        OPERATORS.clear();
        return result;
    }

    private void calculate(String character) {
        if (isNumber(character)) {
            pushOrOperate(character);
        }
        if (isOperator(character)) {
            OPERATORS.push(character);
        }
    }

    private boolean isNumber(String character) {
        return NUMBER_PATTERN.matcher(character).matches();
    }

    private void pushOrOperate(String character) {
        if (OPERATORS.isEmpty()) {
            NUMBERS.push(Integer.parseInt(character));
        }
        if (!OPERATORS.isEmpty()) {
            Integer previous = NUMBERS.pop();
            String operator = OPERATORS.pop();
            operate(character, previous, operator);
        }
    }

    private boolean isOperator(String character) {
        return !isNumber(character);
    }

    private void operate(String character, Integer previous, String operator) {
        int current = Integer.parseInt(character);
        switch (operator) {
            case "+":
                NUMBERS.push(previous + current);
                break;
            case "-":
                NUMBERS.push(previous - current);
                break;
            case "*":
                NUMBERS.push(previous * current);
                break;
            case "/":
                validateRemainder(previous % current);
                NUMBERS.push(previous / current);
            default:
                break;
        }
    }

    private void validateRemainder(int remainder) {
        if (remainder != 0) {
            throw new IllegalStateException(DIVIDE_RESULT_SHOULD_BE_INTEGER.getMessage());
        }
    }
}

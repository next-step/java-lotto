package stringcalculator;

import java.util.*;

public class StringCalculator {

    private final StringInputParser stringInputParser;
    private final Deque<String> numbers;
    private final Deque<String> operators;

    public StringCalculator(StringInputParser stringInputParser) {
        this.stringInputParser = stringInputParser;
        this.numbers = new LinkedList<>();
        this.operators = new LinkedList<>();
    }

    public String calculate(String input) {
        initQueue();
        parseInput(input);

        while (numbers.size() > 1) {
            String a = numbers.poll();
            String b = numbers.poll();
            String op = operators.poll();
            Long result = operate(a, b, op);
            numbers.addFirst(result.toString());
        }

        return numbers.poll();
    }

    private Long operate(String a, String b, String op) {
        if (op.equals("+")) {
            return add(a, b);
        }
        if (op.equals("-")) {
            return subtract(a, b);
        }
        if (op.equals("*")) {
            return multiply(a, b);
        }
        if (op.equals("/")) {
            return divide(a, b);
        }

        throw new IllegalArgumentException("지원하지 않는 Operator 입니다.");
    }

    private void initQueue() {
        numbers.clear();
        operators.clear();
    }

    private void parseInput(String inputString) {
        List<String> parsedInput = stringInputParser.parse(inputString);

        extractNumbers(parsedInput);
        extractOperators(parsedInput);
    }

    private void extractNumbers(List<String> parsedInput) {
        for (int i = 0; i < parsedInput.size(); i++) {
            if (i % 2 == 0) {
                String number = parsedInput.get(i);
                StringTokenValidator.validateNumberToken(number);
                numbers.add(number);
            }
        }
    }

    private void extractOperators(List<String> parsedInput) {
        for (int i = 0; i < parsedInput.size(); i++) {
            if (i % 2 != 0) {
                String operator = parsedInput.get(i);
                StringTokenValidator.validateOperatorToken(operator);
                operators.add(parsedInput.get(i));
            }
        }
    }


    Long add(String a, String b) {
        return Long.parseLong(a) + Long.parseLong(b);
    }

    Long subtract(String a, String b) {
        return Long.parseLong(a) - Long.parseLong(b);
    }

    Long multiply(String a, String b) {
        return Long.parseLong(a) * Long.parseLong(b);
    }

    Long divide(String a, String b) {
        return Long.parseLong(a) / Long.parseLong(b);
    }
}

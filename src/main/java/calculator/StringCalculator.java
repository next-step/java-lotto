package calculator;

import calculator.operator.*;
import com.google.common.annotations.VisibleForTesting;

import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    private final List<Operator> operators;

    public StringCalculator() {
        this.operators = Arrays.asList(new Plus(), new Minus(), new Multiply(), new Divide());
    }

    public int calculate(String input) {
        String[] tokens = splitInput(input);
        return calculateTokens(tokens);
    }

    @VisibleForTesting
    String[] splitInput(String input) {
        return input.split(" ");
    }

    private int calculateTokens(String[] tokens) {
        int result = getFirstNumber(tokens[0]);
        Operator operator = null;

        for (int i = 1; i < tokens.length; i++) {
            String token = tokens[i];

            if (isOperator(token)) {
                operator = findOperator(token);
                continue;
            }

            int number = parseNumber(token);
            assert operator != null;
            result = calculateStep(result, operator, number);
            operator = null;
        }

        return result;
    }

    private int getFirstNumber(String token) {
        return parseNumber(token);
    }

    @VisibleForTesting
    int parseNumber(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
        }
    }

    private boolean isOperator(String token) {
        return !Character.isDigit(token.charAt(0));
    }

    private Operator findOperator(String token) {
        return operators.stream()
                .filter(s -> s.isOperator(token))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 연산자입니다."));
    }

    private int calculateStep(int a, Operator operator, int b) {
        return operator.calculate(a, b);
    }
}


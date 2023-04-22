package stringcalculator;

import java.util.*;

public class Expression {
    private static final Map<String, Operator> operatorRegistry;

    static  {
        operatorRegistry = Map.of(
            "+", new Addition(),
            "-", new Subtraction(),
            "*", new Multiplication(),
            "/", new Division()
        );
    }

    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public Expression(String input) {
        String[] tokens = tokenizeInput(input);

        for (int i = 0; i < tokens.length; i++) {
            processToken(tokens, i);
        }
    }

    private static String[] tokenizeInput(String input) {
        if (!StringUtils.hasText(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        String[] tokens = input.split(" ");
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return tokens;
    }

    private void processToken(String[] tokens, int i) {
        if (i % 2 == 0) {
            addNumber(tokens[i]);
        } else {
            addOperator(tokens[i]);
        }
    }

    private void addOperator(String tokens) {
        Operator operator = operatorRegistry.get(tokens);
        if (operator == null) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        operators.add(operatorRegistry.get(tokens));
    }

    private void addNumber(String tokens) {
        try {
            numbers.add(Integer.parseInt(tokens));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public int evaluate() {
        int result = numbers.get(0);
        for (int i = 0; i < operators.size(); i++) {
            result = operators.get(i).apply(result, numbers.get(i + 1));
        }
        return result;
    }
}

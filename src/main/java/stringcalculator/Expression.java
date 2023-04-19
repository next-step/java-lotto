package stringcalculator;

import java.util.*;

public class Expression {
    private static final Map<String, Operator> operatorMap;

    static  {
        operatorMap = Map.of(
            "+", new Addition(),
            "-", new Subtraction(),
            "*", new Multiplication(),
            "/", new Division()
        );
    }

    private final List<Integer> numbers = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public Expression(String input) {
        if (!StringUtils.hasText(input)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        String[] tokens = input.split(" ");
        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        for (int i = 0; i < tokens.length; i++) {
            if (i % 2 == 0) {
                try {
                    numbers.add(Integer.parseInt(tokens[i]));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            } else {
                Operator operator = operatorMap.get(tokens[i]);
                if (operator == null) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
                operators.add(operatorMap.get(tokens[i]));
            }
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

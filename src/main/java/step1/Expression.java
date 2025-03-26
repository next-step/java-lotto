package step1;


import java.util.ArrayList;
import java.util.List;

public class Expression {
    private final Operands operands;
    private final Operators operators;
    private static final String DELIMITER = " ";
    private static final int PIVOT_INDEX = 0;

    public Expression(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }

        String[] tokens = input.split(DELIMITER);
        List<String> operands = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        if (tokens.length % 2 == 0) {
            throw new IllegalArgumentException("올바른 식이 아닙니다.");
        }

        operands.add(tokens[PIVOT_INDEX]);
        for (int i = 1; i < tokens.length; i += 2) {
            operators.add(tokens[i]);
            operands.add(tokens[i + 1]);
        }

        this.operands = new Operands(operands);
        this.operators = new Operators(operators);
    }

    public int calc() {
        int result = operands.get(PIVOT_INDEX).getValue();
        for (int i = 0; i < operators.size() && i + 1 < operands.size(); i++) {
            result = operators.get(i).apply(result, operands.get(i + 1).getValue());
        }
        return result;
    }
}

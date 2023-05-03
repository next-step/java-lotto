package calculator.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String SEPARATOR = " ";
    private final static List<String> OPERATOR = List.of("+", "-", "*", "/");
    private final String formula;
    private final List<Double> operands = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();

    public InputView(String formula) {
        if (formula == null || formula.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백 문자를 전달할 수 없습니다.");
        }

        Arrays.stream(formula.split(SEPARATOR))
                .forEach(s -> {
                    if (isOperand(s)) {
                        operands.add(Double.parseDouble(s));
                    } else {
                        operators.add(s);
                    }
                });

        for (String o : operators) {
            if (!isOperator(o)) throw new IllegalArgumentException("올바른 사칙연산이 아닙니다.");
        }
        this.formula = formula;
    }

    private boolean isOperator(String operator) {
        return OPERATOR.contains(operator);
    }
    private boolean isOperand(String operand) {
        try {
            Double.valueOf(operand);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Double> getOperands() {
        return operands;
    }

    public String getFormula() {
        return formula;
    }

    public List<String> getOperators() {
        return operators;
    }
}

package calculator.view;

import calculator.domain.Operand;
import calculator.domain.Operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String SEPARATOR = " ";
    private final String formula;
    private final List<Operand> operands = new ArrayList<>();
    private final List<Operator> operators = new ArrayList<>();

    public InputView(String formula) {
        if (formula == null || formula.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백 문자를 전달할 수 없습니다.");
        }

        Arrays.stream(formula.split(SEPARATOR))
                .forEach(s -> {
                    if (isOperand(s)) {
                        operands.add(new Operand(Double.valueOf(s)));
                    } else {
                        operators.add(new Operator(s));
                    }
                });
        this.formula = formula;
    }

    private boolean isOperand(String operand) {
        try {
            Double.valueOf(operand);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<Operand> getOperands() {
        return operands;
    }

    public List<Operator> getOperators() {
        return operators;
    }
}

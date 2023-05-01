package calculator.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final static String SEPARATOR = " ";
    private final static List<String> OPERATOR = List.of("+", "-", "*", "/");
    private final String formula;
    private final List<Long> operands = new ArrayList<>();
    private final List<String> operators = new ArrayList<>();

    public InputView(String formula) {
        if (formula == null || formula.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백 문자를 전달할 수 없습니다.");
        }

        Arrays.stream(formula.split(SEPARATOR))
                .forEach(s -> {
                    if (isOperator(s)) operators.add(s);
                    if (isOperand(s)) operands.add(Long.parseLong(s));
                });

        operators.stream()
                .filter(this::isOperand)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
        this.formula = formula;
    }

    private boolean isOperator(String operator) {
        for(String o : OPERATOR){
            if (o.equals(operator)) return true;
        }
        return false;
    }
    private boolean isOperand(String operand) {
        try {
            Long.parseLong(operand);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

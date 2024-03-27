package calculator.domain;

import java.util.Arrays;
import java.util.List;

public class ParsedFormula {
    private final List<String> VALID_OPERANDS = List.of("+", "-", "*", "/");
    private final List<String> parsedFormula;

    ParsedFormula(List<String> parsedFormula) {
        this.parsedFormula = parsedFormula;
    }

    ParsedFormula(String formula) {
        this(Arrays.asList(formula.split(" ")));
    }

    public String getOperator(int currentPosition) {
        String operand = this.parsedFormula.get(currentPosition);

        if (!this.validateOperator(operand)) {
            throw new IllegalArgumentException("허용된 사칙연산 기호가 아닙니다.");
        }

        return operand;
    }

    public int getOperand(int currentPosition) {
        try {
            return Integer.parseInt(this.parsedFormula.get(currentPosition));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("피연산자가 입력되지 않았습니다.");
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("피연산자는 정수값이어야 합니다.");
        }
    }

    public int getLength() {
        return this.parsedFormula.size();
    }

    private boolean validateOperator(String operator) {
        return VALID_OPERANDS.contains(operator);
    }
}

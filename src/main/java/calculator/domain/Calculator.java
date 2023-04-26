package calculator.domain;

import calculator.utils.Conversion;
import calculator.utils.Split;

public class Calculator extends Operator {

    private final Result result;
    private final Elements elements;

    public Calculator(String str) {
        validateString(str);
        this.elements = new Elements(Split.getStrings(str));
        this.result = new Result(Conversion.stringToInt(elements.getFirstOperand()));
    }

    public int calculate() {

        for (int index = 1; index < elements.getSize(); index += 2) {
            String operator = elements.getOperator(index);
            int operand = Conversion.stringToInt(elements.getOperand(index + 1));

            add(operator, operand);
            subtract(operator, operand);
            multiply(operator, operand);
            divide(operator, operand);
        }

        return this.result.get();
    }

    private void divide(String operator, int operand) {
        if (operator.equals(DIVIDE_OPERATOR)) {
            this.result.divide(operand);
        }
    }

    private void multiply(String operator, int operand) {
        if (operator.equals(MULTIPLY_OPERATOR)) {
            this.result.multiply(operand);
        }
    }

    private void subtract(String operator, int operand) {
        if (operator.equals(SUBTRACT_OPERATOR)) {
            this.result.subtract(operand);
        }
    }

    private void add(String operator, int operand) {
        if (operator.equals(ADD_OPERATOR)) {
            this.result.add(operand);
        }
    }

    private void validateString(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException("입력값이 올바르지 않습니다.");
        }
    }
}

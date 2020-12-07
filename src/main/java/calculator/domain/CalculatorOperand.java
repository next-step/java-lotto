package calculator.domain;

import java.util.Objects;

public class CalculatorOperand {
    private int operand;

    public CalculatorOperand(String operand) {
        int operandParsedInteger = Integer.parseInt(operand);
        if (this.isNegativeInteger(operandParsedInteger)) {
            throw new IllegalArgumentException("음수는 입력 할 수 없습니다.");
        }
        this.operand = operandParsedInteger;
    }

    public int getOperand() {
        return this.operand;
    }

    private boolean isNegativeInteger(int operand) {
        return operand < 0;
    }

    public CalculatorOperand sum(CalculatorOperand calculatorOperand) {
        this.operand += calculatorOperand.getOperand();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalculatorOperand calculatorOperand1 = (CalculatorOperand) o;
        return Objects.equals(operand, calculatorOperand1.operand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operand);
    }
}

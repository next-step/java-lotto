package calculator.domain.calculator;

import calculator.domain.Calculable;

public class DivisionCalulcator implements Calculable {

    @Override
    public int calculate(int preResult, int operand) {
        validateOperand(operand);
        return preResult / operand;
    }

    private static void validateOperand(int operand) {
        if (operand == 0) {
            throw new IllegalArgumentException("나누기 피연산자는 0이 될 수 없습니다.");
        }
    }
}

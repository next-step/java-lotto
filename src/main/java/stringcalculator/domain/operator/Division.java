package stringcalculator.domain.operator;

import stringcalculator.exception.StringCalculatorIllegalArgumentException;

public class Division implements Operator {

    private static final String DIVIDE = "/";

    @Override
    public int calculate(int operand1, int operand2) {
        if (operand2 == 0) {
            throw new StringCalculatorIllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        if(operand1 % operand2 != 0) {
            throw new StringCalculatorIllegalArgumentException("나눗셈의 결과가 정수로 떨어지지 않습니다.");
        }
        return operand1 / operand2;
    }

    @Override
    public boolean supports(String operator) {
        return DIVIDE.equals(operator);
    }
}

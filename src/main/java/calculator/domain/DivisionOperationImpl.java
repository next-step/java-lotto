package calculator.domain;

import java.security.InvalidParameterException;

public class DivisionOperationImpl implements Operation {
    @Override
    public int calculate(int num1, int num2) {
        checkValidation(num1, num2);
        return (int) num1 / num2;
    }

    public void checkValidation(int num1, int num2) {
        if (num2 == 0) {
            throw new InvalidParameterException("0으로 나눌수 없습니다.");
        }

        if (num1 % num2 > 0) {
            throw new InvalidParameterException("정수로 나누어 떨어지지 않으면 나눌 수 없습니다.");
        }
    }
}

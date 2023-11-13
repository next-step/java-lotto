package calculator.domain.operator;

import calculator.exception.DivisionResultFloatException;

public class Division implements Operator {
    public int operate(int num1, int num2) {
        validateDivision(num1, num2);
        return num1 / num2;
    }

    private void validateDivision(int num1, int num2) {
        if (num1 % num2 != 0) {
            throw new DivisionResultFloatException();
        }
    }
}

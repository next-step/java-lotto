package calculator.domain.operator;

public class Division implements Operator {
    public int operate(int num1, int num2) {
        validateDivision(num1, num2);
        return num1 / num2;
    }

    private void validateDivision(int num1, int num2) {
        if (num1 % num2 != 0) {
            throw new IllegalArgumentException("나눗셈의 결과가 정수가 아닙니다.");
        }
    }
}

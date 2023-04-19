package stringcalculator;

public class Division implements Operator {
    @Override
    public int apply(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        if (num1 % num2 != 0) {
            throw new IllegalArgumentException("나눗셈의 결과가 정수로 떨어지지 않습니다.");
        }
        return num1 / num2;
    }
}

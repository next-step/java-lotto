package calculator;

public class Divide extends Operator {

    @Override
    int operate(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return num1 / num2;
    }
}

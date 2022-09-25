package calculator.type;

public class Divide extends Operator {
    private static final String DIVIDE_ZERO_MESSAGE = "0으로 나눌 수 없습니다.";

    @Override
    public int operate(int num1, int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException(DIVIDE_ZERO_MESSAGE);
        }

        return num1 / num2;
    }
}

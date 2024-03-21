package calculator.operator;

public class Divide implements Operator {

    @Override
    public int calculate(int number1, int number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("0으로는 나눌 수 없습니다.");
        }
        return number1 / number2;
    }
}

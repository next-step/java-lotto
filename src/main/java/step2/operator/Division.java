package step2.operator;

public class Division implements Operation{
    @Override
    public int calculate(int number1, int number2) {
        if (number2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }

        return number1 / number2;
    }
}

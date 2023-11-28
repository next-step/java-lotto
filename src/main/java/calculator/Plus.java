package calculator;

public class Plus implements BasicOperator{
    @Override
    public int calculate(int number1, int number2) {
        return number1 + number2;
    }
}

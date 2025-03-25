package step2.operator;

public class Subtraction implements Operation{
    @Override
    public int calculate(int number1, int number2) {
        return number1 - number2;
    }
}

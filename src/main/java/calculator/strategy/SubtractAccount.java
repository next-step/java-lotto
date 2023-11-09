package calculator.strategy;

public class SubtractAccount implements Account {

    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber - secondNumber;
    }
}

package calculator.strategy;

public class DivideAccount implements Account {

    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber / secondNumber;
    }
}

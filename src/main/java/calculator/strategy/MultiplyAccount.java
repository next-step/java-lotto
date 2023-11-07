package calculator.strategy;

public class MultiplyAccount implements Account {

    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber * secondNumber;
    }
}

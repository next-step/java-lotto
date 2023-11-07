package calculator.strategy;

public class AddtionAccount implements Account {

    @Override
    public int calculate(int firstNumber, int secondNumber) {
        return firstNumber + secondNumber;
    }
}

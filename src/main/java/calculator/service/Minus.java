package calculator.service;

public class Minus implements CalculatorInterface {

    @Override
    public int calculate(int number1, int number2) {
        return number1 - number2;
    }
}

package service;

public class Minus implements CalculatorImpl {

    @Override
    public int calculate(int number1, int number2) {
        return number1 - number2;
    }
}

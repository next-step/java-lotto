package service;

public class Plus implements CalculatorInterface {

    @Override
    public int calculate(int number1, int number2) {
        return number1 + number2;
    }
}

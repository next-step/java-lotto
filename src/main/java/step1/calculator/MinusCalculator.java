package step1.calculator;

public class MinusCalculator implements Calculator {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}

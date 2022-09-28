package step1.calculator;

public class MultiplyCalculator implements Calculator {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}

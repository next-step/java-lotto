package step1.calculator;

public class AddCalculator implements Calculator {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}

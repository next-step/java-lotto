package stringcalculator.domain.calculation;

public class Subtraction implements Calculation {
    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 - operand2;
    }
}

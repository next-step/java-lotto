package domain.calculation;

public class Division implements Calculation {
    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 / operand2;
    }
}

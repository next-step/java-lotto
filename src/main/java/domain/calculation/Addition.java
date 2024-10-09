package domain.calculation;

public class Addition implements Calculation {
    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 + operand2;
    }
}

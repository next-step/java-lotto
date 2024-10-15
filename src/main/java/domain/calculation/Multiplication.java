package domain.calculation;

public class Multiplication implements Calculation {
    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 * operand2;
    }
}

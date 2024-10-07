package step1.operater;

public class Division implements Operater {
    @Override
    public int calculate(int operand1, int operand2) {
        return (int) (operand1 / operand2);
    }
}

package step1.operater;

public class Addition implements Operater {
    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 + operand2;
    }
}

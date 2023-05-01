package Calculator.Operator;

public class Divide extends Operator {
    public int operate(int operand1, int operand2) {
        return operand1 / operand2;
    }

    public boolean supported(String operator) {
        return "/".equals(operator);
    }
}

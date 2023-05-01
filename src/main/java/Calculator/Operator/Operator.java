package Calculator.Operator;

public abstract class Operator {
    public abstract int operate(int operand1, int operand2);

    public abstract boolean supported(String operator);
}

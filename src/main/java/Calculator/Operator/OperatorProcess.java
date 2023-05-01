package Calculator.Operator;

public class OperatorProcess {
    private int operand1;
    private int operand2;
    private String operator;

    public OperatorProcess(int operand1, int operand2, String operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = operator;
    }

    public int calculateProcess() {
        if (operator.equals("+")) {
            Operator add = new Add();
            return add.operate(operand1, operand2);
        }
        if (operator.equals("-")) {
            Operator minus = new Minus();
            return minus.operate(operand1, operand2);
        }
        if (operator.equals("*")) {
            Operator multiply = new Multiply();
            return multiply.operate(operand1, operand2);
        }
        if (operator.equals("/")) {
            Operator divide = new Divide();
            return divide.operate(operand1, operand2);
        }

        throw new IllegalArgumentException(operator + "는 사칙연산 기호가 아닙니다: ");
    }
}

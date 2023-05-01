package Calculator.Operator;

import java.util.ArrayList;

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
        ArrayList<Operator> operators = addOperators();

        for (Operator myOperator : operators) {
            Integer result = getResult(myOperator);
            if (result != null) return result;
        }
        throw new IllegalArgumentException(operator + "는 사칙연산 기호가 아닙니다: ");

    }

    private Integer getResult(Operator myOperator) {
        if (myOperator.supported(operator)) {
            return myOperator.operate(operand1, operand2);
        }
        return null;
    }

    private static ArrayList<Operator> addOperators() {
        ArrayList<Operator> operators = new ArrayList<>();

        operators.add(new Add());
        operators.add(new Minus());
        operators.add(new Multiply());
        operators.add(new Divide());
        return operators;
    }
}

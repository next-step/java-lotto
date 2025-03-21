package step1.calc.operator;

import step1.calc.operand.Operand;
import step1.calc.operation.Operation;
import step1.calc.operation.addition.Addition;
import step1.calc.operation.division.Division;
import step1.calc.operation.multiplication.Multiplication;
import step1.calc.operation.subtraction.Subtraction;

public class Operator {

    private final Operation operation;

    public Operator(String operation, Operand a, Operand b) {
        this.operation = classifyOperator(operation, a, b);
    }

    private Operation classifyOperator(String operator, Operand a, Operand b) {
        if (operator.equals("+")) {
            return new Addition(a, b);
        }
        if (operator.equals("-")) {
            return new Subtraction(a, b);
        }
        if (operator.equals("*")) {
            return new Multiplication(a, b);
        }
        if (operator.equals("/")) {
            return new Division(a, b);
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
    }

    public Operand operate() {
        return operation.operate();
    }

}

package calculator.domain;

public class Calculator {
    private final Operand operand1;
    private final Operator operator;
    private final Operand operand2;

    public Calculator() {
        this(0.0, "+",0.0);
    }

    public Calculator(Double operand1, String operator, Double operand2) {
        this.operand1 = new Operand(operand1);
        this.operator = new Operator(operator);
        this.operand2 = new Operand(operand2);
    }

    public Double calculate() {
        if ("+".equals(operator.getOperator())) {
            return add();
        }
        if ("-".equals(operator.getOperator())) {
            return subtract();
        }
        if ("*".equals(operator.getOperator())) {
            return multiple();
        }
        if ("/".equals(operator.getOperator())) {
            return divide();
        }
        return 0.0;
    }

    private Double add() {
        return operand1.getOperand() + operand2.getOperand();
    }

    private Double subtract() {
        return operand1.getOperand() - operand2.getOperand();
    }

    private Double multiple() {
        return operand1.getOperand() * operand2.getOperand();
    }

    private Double divide() {
        return operand1.getOperand() / operand2.getOperand();
    }

}

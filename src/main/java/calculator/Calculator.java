package calculator;

public class Calculator {
    public Operand calculator(Operator operator, Operand left, Operand right) {
        return operator.calculate(left, right);
    }

}

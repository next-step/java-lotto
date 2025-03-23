package calculator;

public class StringCalculator {

    public Operand calculator(Operator operator, Operand left, Operand right) {
        return operator.calculate(left, right);
    }
}

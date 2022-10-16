package step1.domain;

import java.util.Objects;

public class MultiplicationOperator implements Operator {

    @Override
    public boolean supports(String rawOperator) {
        return Objects.equals(rawOperator, "*");
    }

    @Override
    public Operand operate(Operand operand1, Operand operand2) {
        return new Operand(operand1.getValue() * operand2.getValue());
    }
}

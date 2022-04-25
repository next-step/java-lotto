package Calculator.domain;

import Calculator.domain.Calculation.Calculation;

public class Operator extends MathematicalExpression {
    private final Calculation calculation;

    public Operator(String operator) {
        this(OperatorEnum.get(operator).getCalculation());
    }

    private Operator(Calculation calculation) {
        validateCalculation(calculation);
        this.calculation = calculation;
    }

    private void validateCalculation(Calculation calculation) {
        if (calculation == null) {
            throw new IllegalArgumentException("계산방식은 null일 수 없습니다.");
        }
    }

    public Operand calculate(Operand left, Operand right) {
        return new Operand(calculation.calculate(left.value(), right.value()));
    }
}

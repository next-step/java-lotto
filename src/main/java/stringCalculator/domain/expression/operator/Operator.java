package stringCalculator.domain.expression.operator;

public interface Operator {

    long calculate(long leftOperand, long rightOperand);

    public boolean isEqualsOperator(String other);
}

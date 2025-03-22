package stringcalcaulator.domain;

public interface Expression {
    int accept(ExpressionCalculator visitor);
}

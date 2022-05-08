package domain;

import java.util.Objects;

public class Operator {

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";
    private String operator;

    public Operator(String operator) {
        this.operator = operator;
    }

    public static boolean isOperator(String input){
        return (input.equals(PLUS) || input.equals(MINUS) || input.equals(MULTIPLICATION) || input.equals(DIVISION));
    }

    public Operand calculate(Operand leftValue, Operand rightValue){
        if (isPlus()) {
            return leftValue.plus(rightValue);
        }
        if (isMinus()) {
            return leftValue.minus(rightValue);
        }
        if (isMultiplication()) {
            return leftValue.multiple(rightValue);
        }
        if (isDivision()) {
            return leftValue.divide(rightValue);
        }
        throw new IllegalArgumentException();
    }

    private boolean isPlus() {
        return operator.equals(PLUS);
    }

    private boolean isMinus() {
        return operator.equals(MINUS);
    }

    private boolean isMultiplication() {
        return operator.equals(MULTIPLICATION);
    }

    private boolean isDivision() {
        return operator.equals(DIVISION);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Operator operator1 = (Operator) o;
        return Objects.equals(operator, operator1.operator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operator);
    }
}

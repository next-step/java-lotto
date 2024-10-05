package stringcalculator.domain.operator;

public interface Operator {
    int calculate(int operand1, int operand2);
    boolean supports(String operator);
}

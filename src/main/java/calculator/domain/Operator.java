package calculator.domain;

public interface Operator {

    int operates(int operand1, int operand2);

    boolean supports(String operator);
}

package calculator.domain;

public interface Operator {
    int operate(int first, int second);
    boolean supports(String operator);
}
